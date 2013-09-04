import scala.actors.Actor

class CounterActor(name: String) extends Actor {
  def act() = {
    loop {
      react {
        case "stop" => {
          println(name + " : stop")
          exit
        }
        case n : Int => {
          for (i <- 1 to n) {
            println(name + " : " + i)
          }
        }
      }
    }
  }
}

val a = new CounterActor("A")
val b = new CounterActor("B")
val c = new CounterActor("C")

a.start
b.start
c.start

a ! 10
b ! 10
c ! 10

a ! "stop"
b ! "stop"
c ! "stop"

