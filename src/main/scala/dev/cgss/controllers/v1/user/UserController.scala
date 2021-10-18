package dev.cgss.controllers.v1.user

import akka.http.scaladsl.server.PathMatcher
import dev.cgss.controllers.v1.VersionOneController

trait UserController extends VersionOneController {

  override protected def rootPathUrl: PathMatcher[Unit] = super.rootPathUrl / "user"

}
