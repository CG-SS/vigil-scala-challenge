package dev.cgss.controllers

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatcher

trait VersionOneController extends Controller {

  override protected def rootPathUrl: PathMatcher[Unit] = super.rootPathUrl /  "v1"

}
