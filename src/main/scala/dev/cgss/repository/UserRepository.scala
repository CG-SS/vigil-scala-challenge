package dev.cgss.repository

import dev.cgss.models.User
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

object UserRepository {

  private val db = Database.forConfig("postgres")

  class UserTable(tag: Tag) extends Table[User](tag, None, "user") {
    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)
    val name: Rep[String] = column[String]("name")
    val email: Rep[String] = column[String]("email")

    override def * = (id, name, email) <> (User.tupled, User.unapply)
  }

  def getUserByName(name: String) : Future[Option[User]] = {
    val userTable = TableQuery[UserTable]

    val query = userTable
      .filter(_.name === name)
      .take(1)

    db.run(query.result.headOption)
  }

}
