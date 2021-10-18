package dev.cgss.controllers.v1

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{as, complete, entity, handleExceptions, onSuccess, post}
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import dev.cgss.models.UserCreationEntity
import dev.cgss.repository.UserRepository
import org.postgresql.util.PSQLException


object UserCreationController extends UserController with SprayJsonSupport {

  val exceptionHandler: ExceptionHandler =
    ExceptionHandler {
      case _: PSQLException =>
        complete(StatusCodes.Conflict)
    }

  override protected def getEndpoints: Route =
    post {
      entity(as[UserCreationEntity]) { newUser =>
        handleExceptions(exceptionHandler) {
          val r = UserRepository.createUser(newUser.userName, newUser.email)
          onSuccess(r) { status =>
            if (status == 1)
              complete(StatusCodes.Created)
            else
              complete(StatusCodes.Conflict)
          }
        }
      }
    }

  override protected def pathEnd: String = "create"

}
