package com.nextperience.jp.advert.services

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.nextperience.jp.advert.http.HttpService
import com.nextperience.jp.advert.http.routes.JsonSupport
import com.nextperience.jp.advert.models.Model._
import org.scalatest.{BeforeAndAfter, Matchers, WordSpec}

class AdvertServiceSpec extends WordSpec with Matchers with ScalatestRouteTest with BeforeAndAfter with JsonSupport {

  val advertService = new AdvertService()
  val httpService = new HttpService(advertService)

  private val advert1: Advert = Advert(1, "title1", "desc1", 10000, JobType.CONTRACT, "me")
  private val advert2: Advert = Advert(2, "title2", "desc2", 20000, JobType.CONTRACT, "me")
  private val advert3: Advert = Advert(3, "title3", "desc3", 30000, JobType.CONTRACT, "me")
  private val advert4: Advert = Advert(4, "title4", "desc4", 50000, JobType.CONTRACT, "me")

  advertService.addNewAdvert(advert1)
  advertService.addNewAdvert(advert2)
  advertService.addNewAdvert(advert3)

  "Advert API" should {
    "returns all of the adverts" in {
      Get("/api/advert") ~> httpService.routes ~> check {
        status.isSuccess() shouldEqual true
        val expectedResponse = Seq(advert1, advert2, advert3)
        responseAs[Seq[Advert]] shouldBe expectedResponse
      }
    }

    "returns all of the adverts when there is a slash at the end of the root" in {
      Get("/api/advert/") ~> httpService.routes ~> check {
        status.isSuccess() shouldEqual true
        val expectedResponse = Seq(advert1, advert2, advert3)
        responseAs[Seq[Advert]] shouldBe expectedResponse
      }
    }

    "returns an advert by id" in {
      Get("/api/advert/1") ~> httpService.routes ~> check {
        status.isSuccess() shouldEqual true
        responseAs[Advert] shouldBe advert1
      }
    }

    "returns 404 if the resource is not found" in {
      Get("/api/advert/15") ~> httpService.routes ~> check {
        status.isFailure() shouldEqual true
      }
    }

    "adds a new advert to the repository" in {
      Post("/api/advert", advert4) ~> httpService.routes ~> check {
        status.isSuccess() shouldEqual true
      }
    }
  }

}
