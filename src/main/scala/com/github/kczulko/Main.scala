package com.github.kczulko

import akka.actor.ActorSystem
import spray.json._
import spray.http.StatusCodes
import spray.routing.SimpleRoutingApp

object Main extends App with SimpleRoutingApp {
  implicit val actorSystem = ActorSystem()

  def printContent(content: String): Unit = {
    println("============================")
    println(
      try {
        content.parseJson.prettyPrint
      } catch {
        case _:Exception =>
          content
      }
    )
    println("============================")
  }

  startServer(interface = "localhost", port = 666) {
    pathPrefix("events" / "listener") {
      pathEnd {
        post {
          entity(as[String]) { content =>
            printContent(content)
            complete(StatusCodes.OK)
          }
        }
      }
    }
  }
}
