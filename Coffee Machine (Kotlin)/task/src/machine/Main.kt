package machine

import java.util.*

fun main() {
    val coffeeMachine = CoffeeMachine()
    while (true) {
        println()
        println("Write action (buy, fill, take, remaining, exit):")
        when (readln()) {
            "buy" ->  buyCoffee(coffeeMachine)
            "fill" -> fillMachine(coffeeMachine)
            "take" -> println("I gave you $${coffeeMachine.take()}")
            "remaining" -> println(coffeeMachine.contentsString())
            "exit" -> return
        }
    }
}

fun fillMachine(coffeeMachine: CoffeeMachine) {
    println("Write how many ml of water you want to add:")
    val water = readln().toInt()
    println("Write how many ml of milk you want to add:")
    val milk = readln().toInt()
    println("Write how many grams of coffee beans you want to add:")
    val beans = readln().toInt()
    println("Write how many disposable cups you want to add:")
    val cups = readln().toInt()

    coffeeMachine.fill(water, milk, beans, cups)
}

fun buyCoffee(coffeeMachine: CoffeeMachine) {
    println()
    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val coffee = when(readln()) {
        "1" -> Coffee.ESPRESSO
        "2" -> Coffee.LATTE
        "3" -> Coffee.CAPPUCCINO
        "back" -> return
        else -> throw InputMismatchException("No such coffee")
    }

    println(
        when {
            !coffeeMachine.enoughWater(coffee) -> "Sorry, not enough water!"
            !coffeeMachine.enoughMilk(coffee) -> "Sorry, not enough milk!"
            !coffeeMachine.enoughBeans(coffee) -> "Sorry, not enough coffee beans!"
            coffeeMachine.cups < 1 -> "Sorry, not enough disposable cups"
            else -> {
                println("I have enough resources, making you a coffee!")
                coffeeMachine.buy(coffee)
                return
            }
        }
    )
}