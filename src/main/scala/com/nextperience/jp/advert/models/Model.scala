package com.nextperience.jp.advert.models

import java.util.UUID

import com.nextperience.jp.advert.models.Model.JobType.JobType
import com.nextperience.jp.advert.utils.BsonImplicits
import reactivemongo.bson.{BSONObjectID, Macros}


object Model extends BsonImplicits {

  case class Id(id: String)
  case class Advert(id: Option[String], title: String, description: String, salary: Int, jobType: JobType, owner: String)

  object Advert {
    implicit val personHandler = Macros.handler[Advert]
  }

  object JobType extends Enumeration {
    type JobType = Value
    val PERMANENT, CONTRACT, TEMPORARY, FULL_TIME, PART_TIME = Value
  }

}
