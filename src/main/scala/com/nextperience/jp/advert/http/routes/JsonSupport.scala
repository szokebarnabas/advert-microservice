package com.nextperience.jp.advert.http.routes

import com.nextperience.jp.advert.models.Model.JobType
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{DefaultFormats, jackson}


trait JsonSupport extends Json4sSupport {
  import org.json4s.ext.EnumNameSerializer

  implicit val serialization = jackson.Serialization
  implicit val formats = DefaultFormats + new EnumNameSerializer(JobType)


}
