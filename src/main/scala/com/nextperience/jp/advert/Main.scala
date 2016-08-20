package com.nextperience.jp.advert

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.nextperience.jp.advert.http.HttpService
import com.nextperience.jp.advert.services.AdvertService
import scala.concurrent.duration._



class Main(implicit val actorSystem: ActorSystem, implicit val actorMaterializer: ActorMaterializer) {

  def startServer(address: String, port: Int) = {

    val advertService = new AdvertService()
    val httpService = new HttpService(advertService)

    Http().bindAndHandle(httpService.routes, address, port)
    println("Advert service has been started.")
  }
}

object Main extends App {

  implicit val actorSystem = ActorSystem("actor-system")
  implicit val actorMaterializer = ActorMaterializer()
  implicit val executionContext = actorSystem.dispatcher
  implicit val timeout = Timeout(10 seconds)

  val server = new Main()
  server.startServer("localhost", 8080)

}
