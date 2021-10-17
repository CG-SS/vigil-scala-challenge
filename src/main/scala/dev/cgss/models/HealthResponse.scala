package dev.cgss.models

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class HealthResponse(msg: String = "Up and running!")

object HealthResponse extends DefaultJsonProtocol {

  implicit val jsonFormat: RootJsonFormat[HealthResponse] = jsonFormat1(HealthResponse.apply)

}


