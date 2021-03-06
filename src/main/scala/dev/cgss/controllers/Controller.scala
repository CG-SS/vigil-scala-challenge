package dev.cgss.controllers

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{PathMatcher, Route}
import dev.cgss.controllers.v1.user.UserCreationController

trait Controller {

  def getRoute: Route = path(rootPathUrl / pathEnd)(getEndpoints)

  protected def rootPathUrl: PathMatcher[Unit] = "api"

  protected def getEndpoints: Route

  protected def pathEnd: String

}

object Controller {

  def getAllControllers: Seq[Controller] = Seq(
    UserCreationController,
    HealthController,
  )

}
