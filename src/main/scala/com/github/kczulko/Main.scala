package com.github.kczulko

import java.util.Calendar

import akka.actor.ActorSystem
import spray.json._
import spray.http.StatusCodes
import spray.routing.SimpleRoutingApp

object Main extends App with SimpleRoutingApp {
  implicit val actorSystem = ActorSystem()

  def printContent(content: String): Unit = {
    val time = Calendar.getInstance().getTime
    println("================= " + time + " =================")
    println(
      try {
        content.parseJson.prettyPrint
      } catch {
        case _:Exception =>
          content
      }
    )
    println("================= " + time + " =================")
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
