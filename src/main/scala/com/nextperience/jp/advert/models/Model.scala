package com.nextperience.jp.advert.models

import com.nextperience.jp.advert.models.Model.JobType.JobType


object Model {

  case class Advert(id: Int, title: String, description: String, salary: Int, jobType: JobType, owner: String)

  case class ErrorResponse(msg: String)

  object JobType extends Enumeration {
    type JobType = Value
    val PERMANENT, CONTRACT, TEMPORARY, FULL_TIME, PART_TIME = Value
  }
}
