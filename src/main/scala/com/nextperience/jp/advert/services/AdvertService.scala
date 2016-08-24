package com.nextperience.jp.advert.services

import java.util.UUID

import com.nextperience.jp.advert.infrastructure.persistence.AdvertRepository
import com.nextperience.jp.advert.models.Model.Advert
import org.slf4j.LoggerFactory
import reactivemongo.bson.BSONDocument

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AdvertService {

  protected val logger = LoggerFactory.getLogger(this.getClass)

  def getAll(): Future[List[Advert]] = AdvertRepository.findAll()

  def get(id: String): Future[Option[Advert]] = {
    val query = BSONDocument("id" -> BSONDocument("$eq" -> id))
    AdvertRepository.findOne(query)
  }

  def save(advert: Advert): Unit = {
    logger.error("new advert")
    AdvertRepository.insert(advert.copy(id = Some(UUID.randomUUID().toString)))
  }

  def update(advert: Advert) = {
    val selector = BSONDocument("id" -> BSONDocument("$eq" -> advert.id))
    AdvertRepository.update(selector, advert)
  }

}
