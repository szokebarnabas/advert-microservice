package com.nextperience.jp.advert.models


object Model {

  case class Advert(id: Int, title: String, description: String, salary: Int, jobType: String, owner: String)

  case class ErrorResponse(msg: String)

//  object JobType extends Enumeration {
//    type JobType = Value
//    val PERMANENT, CONTRACT, TEMPORARY, FULL_TIME, PART_TIME = Value
//  }

  sealed trait JobType

  object JobType {
    case object PERMANENT extends JobType
    case object CONTRACT extends JobType
    case object TEMPORARY extends JobType
    case object FULL_TIME extends JobType
    case object PART_TIME extends JobType

  }
}
