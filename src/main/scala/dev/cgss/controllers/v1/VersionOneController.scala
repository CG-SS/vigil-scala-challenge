package dev.cgss.controllers.v1

import akka.http.scaladsl.server.PathMatcher
import dev.cgss.controllers.Controller

trait VersionOneController extends Controller {

  override protected def rootPathUrl: PathMatcher[Unit] = super.rootPathUrl / "v1"

}
