package dev.cgss.controllers

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, path}
import akka.http.scaladsl.server.{Directives, Route}

object HealthController extends Controller {

  override def getRoute: Route =
    path("/health") {
      Directives.get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }

}
