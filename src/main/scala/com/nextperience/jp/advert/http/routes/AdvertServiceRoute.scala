package com.nextperience.jp.advert.http.routes

import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives
import com.nextperience.jp.advert.models.Model.Advert
import com.nextperience.jp.advert.services.AdvertService

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
                advertService.addNewAdvert(advert)
                HttpResponse(StatusCodes.Created)
              }
            }
          }
      } ~
        path(IntNumber) { id =>
          get {
            complete {
              advertService.get(id) match {
                case Some(advert) => advert
                case None => HttpResponse(StatusCodes.NotFound, entity = "Advert not found")
              }
            }
          }
        }
    }
}
