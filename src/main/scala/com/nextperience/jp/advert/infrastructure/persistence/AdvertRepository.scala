package com.nextperience.jp.advert.infrastructure.persistence

import com.nextperience.jp.advert.models.Model.Advert
import reactivemongo.api.{DB, MongoDriver}
import reactivemongo.bson.BSONObjectID
import reactivemongo.extensions.dao.BsonDao

import scala.concurrent.ExecutionContext.Implicits.global

object MongoContext {
  val driver = new MongoDriver
  val connection = driver.connection(List("localhost"))
  def db: DB = connection("advert-db")
}

object AdvertRepository extends BsonDao[Advert, BSONObjectID](MongoContext.db, "advert")
