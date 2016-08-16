package com.nextperience.jp.advert.http

import akka.http.scaladsl.server.Directives._
import com.nextperience.jp.advert.http.routes.AdvertServiceRoute
import com.nextperience.jp.advert.services.AdvertService

class HttpService(advertService: AdvertService) {

  val advertRouter = new AdvertServiceRoute(advertService)

  val routes =
    pathPrefix("api") {
      advertRouter.route
    }

}
