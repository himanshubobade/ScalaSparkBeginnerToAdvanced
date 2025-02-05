package com.example.scalaFundamentals.ConcurrencyParallelism.AkkaActorsModel

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}

object StopActor {
  def apply(): Behavior[String] = Behaviors.receive { (_, message) =>
    println(s"Received: $message")
    Behaviors.stopped  // Stops the actor
  }
}
object AkkaActorsModelStopActor {
  def AkkaActorsModelStopActor(): Unit = {
      val system = ActorSystem(StopActor(), "StopActorSystem")
      system ! "Hello"
      system ! "This won't be processed since the actor stops"
  }

}
