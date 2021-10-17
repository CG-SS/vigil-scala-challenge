package dev.cgss.controllers

import akka.http.scaladsl.server.Directives.{authenticateBasicAsync, extractExecutionContext}
import akka.http.scaladsl.server.Route
import dev.cgss.services.auth.BasicAuthService

trait SecureController extends Controller {
  override def getRoute: Route = extractExecutionContext { implicit executor =>
    authenticateBasicAsync("secure-controller", BasicAuthService.apply) { _ =>
      super.getRoute
    }
  }
}
