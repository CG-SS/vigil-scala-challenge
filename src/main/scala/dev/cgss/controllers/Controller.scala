package dev.cgss.controllers

import akka.http.scaladsl.server.Directives.path
import akka.http.scaladsl.server.Route

trait Controller {

  def getRoute: Route = path(rootPathUrl + name)(getEndpoints)

  def rootPathUrl: String = "/api"

  def getEndpoints: Route

  def name : String

}

object Controller {

  def getAllControllers: Seq[Route] = Seq()

}
