package dev.cgss

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.typesafe.scalalogging.LazyLogging
import dev.cgss.controllers.Controller
import slick.jdbc.JdbcBackend.Database
import slick.lifted.Tag
import slick.jdbc.PostgresProfile.api._

import java.time.LocalDate
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.impl.Promise
import scala.concurrent.{Await, ExecutionContextExecutor, Future}
import scala.sys.addShutdownHook
import scala.util.{Failure, Success}


object Main extends App with LazyLogging {

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
