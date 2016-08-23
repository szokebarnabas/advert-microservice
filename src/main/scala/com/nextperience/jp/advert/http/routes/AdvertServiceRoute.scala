package com.nextperience.jp.advert.http.routes

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives
import com.nextperience.jp.advert.models.Model.Advert
import com.nextperience.jp.advert.services.AdvertService
import scala.util.{Failure, Success}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class AdvertServiceRoute(advertService: AdvertService) extends Directives with JsonSupport {

  def divide(a: Int, b: Int): Future[Int] = Future {
    a / b
  }

  val route =
    pathPrefix("advert") {
      pathEndOrSingleSlash {
        get {
          complete {
            advertService.getAll()
          }
        } ~
          post {
            entity(as[Advert]) { advert =>
              complete {
                advertService.addNewAdvert(advert)
                HttpResponse(StatusCodes.Created)
              }
            }
          }
      } ~
        path(Segment) { id =>
          onComplete(advertService.get(id)) {
            case Success(Some(value)) => complete(value)
            case Success(None) => complete(HttpResponse(StatusCodes.NotFound, entity = s"Advert not found: $id"))
            case Failure(ex)    => complete(ex)
          }
        }
    }
}