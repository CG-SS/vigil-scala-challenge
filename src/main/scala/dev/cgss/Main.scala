package dev.cgss

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import dev.cgss.controllers.Controller

import scala.concurrent.ExecutionContextExecutor
import scala.sys.addShutdownHook


object Main extends App {

  implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "Virgil")
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  val bindingFuture = Http()
    .newServerAt("localhost", 8080)
    .bind(
      Controller
        .getAllControllers
        .map(_.getRoute)
        .reduce(_ ~ _)
    )

  addShutdownHook {
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
