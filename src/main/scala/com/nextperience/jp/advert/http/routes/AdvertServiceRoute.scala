package com.nextperience.jp.advert.http.routes

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives
import com.nextperience.jp.advert.models.Model.Advert
import com.nextperience.jp.advert.services.AdvertService

import scala.util.{Failure, Success}

class AdvertServiceRoute(advertService: AdvertService) extends Directives with JsonSupport {

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
                advertService.save(advert)
                HttpResponse(StatusCodes.Created)
              }
            }
          }
      } ~
        path(Segment) { id =>
          get {
            onComplete(advertService.get(id)) {
              case Success(Some(value)) => complete(value)
              case Success(None) => complete(HttpResponse(StatusCodes.NotFound, entity = s"Advert not found: $id"))
              case Failure(ex) => complete(ex)
            }
          } ~
          put {
            entity(as[Advert]) { advert =>
              complete {
                advertService.update(advert)
                HttpResponse(StatusCodes.Created)
              }
            }
          }
        }
    }
}