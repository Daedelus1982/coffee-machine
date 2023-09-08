package machine

import kotlin.math.min

const val WATER_PER_CUP = 200
const val MILK_PER_CUP = 50
const val BEANS_PER_CUP = 15
fun main() {
    val currentWater = currentWaterInput()
    val currentMilk = currentMilkInput()
    val currentBeans = currentBeansInput()
    println("Write how many cups of coffee you will need:")
    val cupsRequired = readln().toInt()
    val possibleCups = cupsCanMakeWith(currentWater, currentMilk, currentBeans)
    println(
        when {
            possibleCups == cupsRequired -> "Yes, I can make that amount of coffee"
            possibleCups > cupsRequired ->
                "Yes, I can make that amount of coffee (and even ${possibleCups - cupsRequired} more than that)"
            else -> "No, I can make only $possibleCups cups of coffee"
    })
}

fun currentWaterInput(): Int {
    println("Write how many ml of water the coffee machine has:")
    return readln().toInt()
}

fun currentMilkInput(): Int {
    println("Write how many ml of milk the coffee machine has:")
    return readln().toInt()
}

fun currentBeansInput(): Int {
    println("Write how many grams of coffee beans the coffee machine has:")
    return readln().toInt()
}

fun cupsCanMakeWith(water: Int, milk: Int, beans: Int): Int {
    val cupsMadeWithWater = water / WATER_PER_CUP
    val cupsMadeWithMilk = milk / MILK_PER_CUP
    val cupsMadeWithBeans = beans / BEANS_PER_CUP

    return listOf(cupsMadeWithWater, cupsMadeWithMilk, cupsMadeWithBeans)
        .reduce { acc, i ->  min(acc, i) }
}
