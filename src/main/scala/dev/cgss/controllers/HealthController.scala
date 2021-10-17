package dev.cgss.controllers

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.typesafe.scalalogging.LazyLogging
import dev.cgss.models.HealthResponse
import dev.cgss.models.HealthResponse.jsonFormat

object HealthController extends SecureController with SprayJsonSupport with LazyLogging {

  override val getEndpoints: Route =
    get {
      complete(HealthResponse())
    }


  override def pathEnd: String = "health"
}
