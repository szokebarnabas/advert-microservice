package com.nextperience.jp.advert.http.routes

import com.nextperience.jp.advert.models.Model.JobType
import com.nextperience.jp.advert.models.Model.JobType.JobType
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{DefaultFormats, jackson}
import reactivemongo.bson.{BSONReader, BSONString, BSONValue, BSONWriter}


trait JsonSupport extends Json4sSupport {
  import org.json4s.ext.EnumNameSerializer

  implicit val serialization = jackson.Serialization
  implicit val formats = DefaultFormats + new EnumNameSerializer(JobType)

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
