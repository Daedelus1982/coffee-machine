package machine

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.printContents()
            "exit" -> return
        }
    }
}