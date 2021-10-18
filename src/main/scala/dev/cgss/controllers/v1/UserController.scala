package dev.cgss.controllers.v1

import akka.http.scaladsl.server.PathMatcher

trait UserController extends VersionOneController {

  override protected def rootPathUrl: PathMatcher[Unit] = super.rootPathUrl / "user"

}
