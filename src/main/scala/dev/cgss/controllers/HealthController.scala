package dev.cgss.controllers

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

object HealthController extends Controller {

  override val getEndpoints: Route =
    get {
      complete(StatusCodes.OK)
    }

  override def pathEnd: String = "health"
}
