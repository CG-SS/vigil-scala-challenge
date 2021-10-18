package dev.cgss.controllers.v1.post

import akka.http.scaladsl.server.PathMatcher
import dev.cgss.controllers.SecureController
import dev.cgss.controllers.v1.VersionOneController

trait PostController extends VersionOneController with SecureController {

  override protected def rootPathUrl: PathMatcher[Unit] = super.rootPathUrl / "post"

}
