package dev.cgss.repository

import dev.cgss.models.Post
import slick.jdbc.JdbcBackend.Database
import slick.lifted.{Rep, Tag}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Future

object PostRepository {

  private val db = Database.forConfig("postgres")

  class PostTable(tag: Tag) extends Table[Post](tag, None, "post") {
    val id: Rep[Option[Long]] = column[Option[Long]]("id", O.AutoInc, O.PrimaryKey)
    val text: Rep[String] = column[String]("text")
    val commentsIdList: Rep[Option[String]] = column[Option[String]]("commentsIdList")
    val imgId: Rep[Option[Long]] = column[Option[Long]]("imgId")
    val userId: Rep[Long] = column[Long]("userId")

    override def * =
      (id, text, commentsIdList, imgId, userId) <>
        ((Post.apply _).tupled, Post.unapply)
  }

  def createPost(post: Post): Future[Int] = {
    val postTable = TableQuery[PostTable]

    val insertPlayerQuery = postTable += post

    db.run(insertPlayerQuery)
  }

  def getPost(id: Long): Future[Option[Post]] = {
    val postTable = TableQuery[PostTable]

    val selectPostQuery =
      postTable
        .filter(_.id.get === id)
        .take(1)

    db.run(selectPostQuery.result.headOption)
  }



}
