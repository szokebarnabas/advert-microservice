package com.nextperience.jp.advert.http.routes

import com.nextperience.jp.advert.models.Model.{Advert, JobType}
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{DefaultFormats, FieldSerializer, jackson}
import reactivemongo.bson.Macros


trait JsonSupport extends Json4sSupport {
  import org.json4s.ext.EnumNameSerializer

  implicit val serialization = jackson.Serialization
  implicit val formats = DefaultFormats + new EnumNameSerializer(JobType)
}
