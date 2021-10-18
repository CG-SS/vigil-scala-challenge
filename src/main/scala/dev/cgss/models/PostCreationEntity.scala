package dev.cgss.models

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class PostCreationEntity(
                                     text: String,
                                     comments: Option[String],
                                     imgId: Option[Long],
                                     userId: Long
                                   )

object PostCreationEntity extends DefaultJsonProtocol {

  implicit val jsonFormat: RootJsonFormat[PostCreationEntity] = jsonFormat4(PostCreationEntity.apply)

}
