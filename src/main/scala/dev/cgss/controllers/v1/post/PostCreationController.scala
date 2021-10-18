package dev.cgss.controllers.v1.post

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{as, complete, entity, handleExceptions, post}
import akka.http.scaladsl.server.{ExceptionHandler, Route}
import dev.cgss.controllers.v1.handleDbOperationComplete
import dev.cgss.models.{Post, PostCreationEntity}
import dev.cgss.repository.PostRepository
import org.postgresql.util.PSQLException

object PostCreationController extends PostController with SprayJsonSupport {

  private val exceptionHandler: ExceptionHandler =
    ExceptionHandler {
      case _: PSQLException =>
        complete(StatusCodes.Conflict)
    }

  override protected def getEndpoints: Route =
    post {
      entity(as[PostCreationEntity]) { newPost =>
        handleExceptions(exceptionHandler) {
          val f = PostRepository.createPost(
            Post(None, newPost.text, newPost.comments, newPost.imgId, newPost.userId)
          )
          handleDbOperationComplete(f)
        }
      }
    }

  override protected def pathEnd: String = "create"
}
