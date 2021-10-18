package dev.cgss.controllers

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives.{complete, onSuccess}
import akka.http.scaladsl.server.Route

import scala.concurrent.Future

package object v1 {

  def handleDbOperationComplete(f:Future[Int]): Route = onSuccess(f) { status =>
    if (status == 1)
      complete(StatusCodes.Created)
    else
      complete(StatusCodes.Conflict)
  }

}
