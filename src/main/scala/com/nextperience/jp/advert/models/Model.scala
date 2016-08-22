package com.nextperience.jp.advert.models

import com.nextperience.jp.advert.models.Model.JobType.JobType
import reactivemongo.bson.{BSONReader, BSONString, BSONValue, BSONWriter, Macros}


object Model {

  case class Advert(id: Int, title: String, description: String, salary: Int, jobType: JobType, owner: String)

  object Advert {

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

    implicit val personHandler = Macros.handler[Advert]
  }

  object JobType extends Enumeration {
    type JobType = Value
    val PERMANENT, CONTRACT, TEMPORARY, FULL_TIME, PART_TIME = Value
  }

}
