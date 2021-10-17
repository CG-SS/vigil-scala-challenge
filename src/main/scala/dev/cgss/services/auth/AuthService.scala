package dev.cgss.services.auth

import akka.http.scaladsl.server.directives.Credentials

import scala.concurrent.{ExecutionContextExecutor, Future}

trait AuthService {

  def apply(credentials: Credentials)(implicit executionContext: ExecutionContextExecutor): Future[Option[Unit]]

}
