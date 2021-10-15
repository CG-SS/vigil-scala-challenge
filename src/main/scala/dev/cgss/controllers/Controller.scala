package dev.cgss.controllers

import akka.http.scaladsl.server.Route

trait Controller {

  def getRoute: Route

}

object Controller {

  def getAllControllers: Seq[Route] = Seq()

}
