package com.nextperience.jp.advert.utils

import com.nextperience.jp.advert.models.Model.{Advert, Id, JobType}
import com.nextperience.jp.advert.models.Model.JobType.JobType
import reactivemongo.bson.{BSONReader, BSONString, BSONValue, BSONWriter, Macros}

trait BsonImplicits {

  implicit object IdWriter extends BSONWriter[Id, BSONString] {
    def write(t: Id): BSONString = BSONString(t.toString)
  }

  implicit object IdReader extends BSONReader[BSONValue, Id] {
    def read(bson: BSONValue): Id = Id("123")
  }

  implicit object JobTypeBsonWriter extends BSONWriter[JobType, BSONString] {
    def write(t: JobType): BSONString = BSONString(t.toString)
  }

  implicit object JobTypeBsonReader extends BSONReader[BSONValue, JobType] {
    def read(bson: BSONValue): JobType = bson match {
      case BSONString("PERMANENT") => JobType.PERMANENT
      case BSONString("CONTRACT") => JobType.CONTRACT
      case BSONString("TEMPORARY") => JobType.TEMPORARY
      case BSONString("FULL_TIME") => JobType.FULL_TIME
      case BSONString("PART_TIME") => JobType.PART_TIME
    }
  }

}
