package machine

import kotlin.math.min

fun main() {
    val coffeeMachine = CoffeeMachine()
    coffeeMachine.printContents()
    println()
    println("Write action (buy, fill, take):")
    when(readln()) {
        "buy" -> coffeeMachine.buy()
        "fill" -> coffeeMachine.fill()
        "take" -> coffeeMachine.take()
    }
    println()
    coffeeMachine.printContents()
}


/*fun cupsCanMakeWith(water: Int, milk: Int, beans: Int): Int {
    val cupsMadeWithWater = water / WATER_PER_CUP
    val cupsMadeWithMilk = milk / MILK_PER_CUP
    val cupsMadeWithBeans = beans / BEANS_PER_CUP

    return listOf(cupsMadeWithWater, cupsMadeWithMilk, cupsMadeWithBeans)
        .reduce { acc, i ->  min(acc, i) }
}*/
