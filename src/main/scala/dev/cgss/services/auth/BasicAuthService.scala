package dev.cgss.services.auth

import akka.http.scaladsl.server.directives.Credentials
import com.typesafe.scalalogging.LazyLogging
import dev.cgss.repository.UserRepository

import scala.concurrent.{ExecutionContextExecutor, Future}

object BasicAuthService extends AuthService with LazyLogging {
  override def apply(credentials: Credentials)(implicit executionContext: ExecutionContextExecutor): Future[Option[Unit]] =
    credentials match {
      case p@Credentials.Provided(identifier) =>
        UserRepository
          .getUserByName(identifier)
          .flatMap {
            case Some(user) =>
              logger.info(s"User ${user.text} trying to login")
              if (p.verify(user.email)) {
                logger.info(s"User ${user.text} logged in")
                Future.successful(Some())
              } else {
                logger.info(s"Failed")
                Future.successful(None)
              }
            case None =>
              logger.info(s"Failed")
              Future.successful(None)
          }
      case _ => Future.successful(None)
    }
}
