package com.nextperience.jp.advert.infrastructure.persistence

import com.nextperience.jp.advert.models.Model.Advert
import reactivemongo.api.collections.bson.BSONCollection
import scala.concurrent.ExecutionContext.Implicits.global


trait AdvertRepository extends MongoRepository {

  val collection = db[BSONCollection]("advert")

  def save(advertEntity: Advert) = {
    val result = collection.insert(advertEntity)
    println(result)
  }
}
