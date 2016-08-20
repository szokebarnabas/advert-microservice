package com.nextperience.jp.advert.models

import com.nextperience.jp.advert.models.Model.JobType.JobType
import reactivemongo.bson.{BSONDocument, BSONDocumentReader, BSONDocumentWriter, BSONObjectID, Macros}


object Model {

  case class Advert(id: Int, title: String, description: String, salary: Int, jobType: String, owner: String)

  object Advert {
    implicit val personHandler = Macros.handler[Advert]
  }
//  object Advert {
//
//    implicit object AdvertEntityBSONReader extends BSONDocumentReader[Advert] {
//      def read(doc: BSONDocument): Advert =
//        Advert(
//          id = doc.getAs[Int]("id").get,
//          title = doc.getAs[String]("title").get,
//          description = doc.getAs[String]("description").get,
//          salary = doc.getAs[Int]("salary").get,
//          jobType = JobType.CONTRACT,
//          owner = doc.getAs[String]("owner").get
//        )
//    }
//
//    implicit object AdvertEntityBSONWriter extends BSONDocumentWriter[Advert] {
//      def write(advert: Advert): BSONDocument =
//        BSONDocument(
//          "_id" -> advert.id,
//          "title" -> advert.title,
//          "description" -> advert.description,
//          "salary" -> advert.salary,
//          "owner" -> advert.owner
//        )
//    }
//
//  }

  case class ErrorResponse(msg: String)

  object JobType extends Enumeration {
    type JobType = Value
    val PERMANENT, CONTRACT, TEMPORARY, FULL_TIME, PART_TIME = Value
  }

}
