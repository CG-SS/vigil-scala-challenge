package dev.cgss.models

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class UserCreationEntity(userName: String, email: String)

object UserCreationEntity extends DefaultJsonProtocol {

  implicit val jsonFormat: RootJsonFormat[UserCreationEntity] = jsonFormat2(UserCreationEntity.apply)

}