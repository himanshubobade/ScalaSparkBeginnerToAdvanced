package com.example.scalaFundamentals.ConcurrencyParallelism.AkkaActorsModel
import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors

// Define an actor with a reply mechanism
object Greeter {
  final case class Greet(whom: String, replyTo: ActorRef[Greeted])
  final case class Greeted(whom: String)

  def apply(): Behavior[Greet] = Behaviors.receive { (context, message) =>
    context.log.info(s"Hello, ${message.whom}!")
    message.replyTo ! Greeted(message.whom)  // Replying back
    Behaviors.same
  }
}

// Main ActorSystem
object AkkaActorsModelReply {
  def AkkaActorsModelReply(): Unit = {
    val greeter = ActorSystem(Greeter(), "GreeterSystem")

    // Define an actor to receive replies
    val replyHandler: ActorRef[Greeter.Greeted] = ActorSystem(
      Behaviors.receiveMessage[Greeter.Greeted] { msg =>
        println(s"Received Reply: ${msg.whom} has been greeted!")
        Behaviors.same
      }, "ReplyHandlerSystem"
    )

    greeter ! Greeter.Greet("Alice", replyHandler)
  }

}





