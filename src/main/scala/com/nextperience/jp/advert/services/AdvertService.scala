package com.nextperience.jp.advert.services

import com.nextperience.jp.advert.infrastructure.persistence.AdvertRepository
import com.nextperience.jp.advert.models.Model.Advert

class AdvertService extends AdvertRepository {

  var adverts: Seq[Advert] = Seq.empty

  def getAll(): Seq[Advert] = adverts

  def get(id: Int): Option[Advert] = adverts.find(_.id == id)

  def addNewAdvert(advert: Advert): Unit = {
    require(advert != null, "The advert cannot be null")
    adverts = adverts :+ advert
    save(advert)
  }

}
