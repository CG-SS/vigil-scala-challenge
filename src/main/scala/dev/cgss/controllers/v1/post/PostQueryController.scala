package dev.cgss.controllers.v1.post

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{_symbol2NR, complete, get, onSuccess, parameters}
import akka.http.scaladsl.server.Route
import dev.cgss.repository.PostRepository

object PostQueryController extends PostController with SprayJsonSupport {

  override protected def getEndpoints: Route =
    get {
      parameters(Symbol("id").as[Int]) { id =>
        val f = PostRepository.getPost(id)
        onSuccess(f) {
          case Some(value) => complete(value)
          case None => complete(StatusCodes.NotFound)
        }
      }
    }

  override protected def pathEnd: String = "query"

}
