package com.nextperience.jp.advert.services

import com.nextperience.jp.advert.infrastructure.persistence.AdvertRepository
import com.nextperience.jp.advert.models.Model.Advert
import reactivemongo.bson.BSONDocument

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AdvertService {

  def getAll(): Future[List[Advert]] = AdvertRepository.findAll()


  def get(id: Int): Option[Advert] = {
    ???
  }

  def addNewAdvert(advert: Advert): Unit = AdvertRepository.insert(advert)

}
