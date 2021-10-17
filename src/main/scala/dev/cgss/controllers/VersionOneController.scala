package dev.cgss.controllers

import akka.http.scaladsl.model.Uri

trait VersionOneController extends Controller {

  override protected def rootPathUrl: String = super.rootPathUrl + Uri./ +  "v1"

}
