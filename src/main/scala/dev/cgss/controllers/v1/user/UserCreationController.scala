package dev.cgss.controllers.v1.user

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{as, complete, entity, handleExceptions, onSuccess, post}
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import dev.cgss.controllers.v1.handleDbOperationComplete
import dev.cgss.models.UserCreationEntity
import dev.cgss.repository.UserRepository
import org.postgresql.util.PSQLException

object UserCreationController extends UserController with SprayJsonSupport {

  private val exceptionHandler: ExceptionHandler =
    ExceptionHandler {
      case _: PSQLException =>
        complete(StatusCodes.Conflict)
    }

  override protected def getEndpoints: Route =
    post {
      entity(as[UserCreationEntity]) { newUser =>
        handleExceptions(exceptionHandler) {
          val f = UserRepository.createUser(newUser.userName, newUser.email)
          handleDbOperationComplete(f)
        }
      }
    }

  override protected def pathEnd: String = "create"

}
