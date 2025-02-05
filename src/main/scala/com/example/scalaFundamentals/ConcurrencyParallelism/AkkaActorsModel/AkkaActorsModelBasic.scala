package com.example.scalaFundamentals.ConcurrencyParallelism.AkkaActorsModel

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}

// Define an Actor that prints messages
object SimpleActor {
  def apply(): Behavior[String] = Behaviors.receive { (context, message) =>
    context.log.info(s"Received Message: $message")
    Behaviors.same  // Keeps the actor alive to process more messages
  }
}

object AkkaActorsModelBasic {
  def AkkaActorsModelBasic(): Unit = {
    val system: ActorSystem[String] = ActorSystem(SimpleActor(), "SimpleActorSystem")

    // Send messages to the actor
    system ! "Hello, Akka!"
    system ! "How are you?"
    system ! "Goodbye!"

  }

}



