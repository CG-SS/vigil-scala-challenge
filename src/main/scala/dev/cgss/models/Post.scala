package dev.cgss.models

import spray.json.{DefaultJsonProtocol, RootJsonFormat}

final case class Post(
                       id: Option[Long],
                       text: String,
                       comments: Option[String],
                       imgId: Option[Long],
                       userId: Long
                     )

object Post extends DefaultJsonProtocol {

  implicit val jsonFormat: RootJsonFormat[Post] = jsonFormat5(Post.apply)

}
