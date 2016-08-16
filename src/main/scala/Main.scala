import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.nextperience.jp.advert.http.HttpService
import com.nextperience.jp.advert.services.AdvertService


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

  val server = new Main()
  server.startServer("localhost", 8080)

}
