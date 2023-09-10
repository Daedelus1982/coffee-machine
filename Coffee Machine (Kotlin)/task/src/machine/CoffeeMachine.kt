package machine

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var beans = 120
    private var money = 550
    private var cups = 9

    fun printContents() {
        println("The coffee machine has:")
        println("$water ml of water")
        println("$milk ml of milk")
        println("$beans g of coffee beans")
        println("$cups disposable cups")
        println("$$money of money")
    }

    private fun enoughResource(coffeeMachineResource: Int, coffeeResource: Int): Boolean =
        coffeeMachineResource - coffeeResource >= 0

    private fun enoughResources(coffee: Coffee): Boolean {

        if (enoughResource(water, coffee.water) &&
            enoughResource(milk, coffee.milk) &&
            enoughResource(beans, coffee.beans) &&
            cups > 1) return true

        val notEnough =  when {
            !enoughResource(water, coffee.water) -> "Sorry, not enough water!"
            !enoughResource(milk, coffee.milk) -> "Sorry, not enough milk!"
            !enoughResource(beans, coffee.beans) -> "Sorry, not enough coffee beans!"
            cups < 1 -> "Sorry, not enough disposable cups"
            else -> "Sorry, not enough"
        }
        println(notEnough)
        return false
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
        val coffee = when(readln()) {
            "1" -> Espresso()
            "2" -> Latte()
            "3" -> Cappuccino()
            else -> return
        }
        if (enoughResources(coffee)) {
            println("I have enough resources, making you a coffee!")
            water -= coffee.water
            milk -= coffee.milk
            beans -= coffee.beans
            cups--
            money += coffee.cost
        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        beans += readln().toInt()
        println("Write how many disposable cups you want to add:")
        cups += readln().toInt()
    }

    fun take() {
        val taken = money
        money = 0
        println("I gave you $$taken")
    }
}

interface Coffee {
    val water: Int
        get() = 0
    val milk: Int
        get() = 0
    val beans: Int
        get() = 0
    val cost: Int
        get() = 0
}

class Espresso: Coffee {
    override val water = 250
    override val beans = 16
    override val cost = 4
}

class Latte: Coffee {
    override val water = 350
    override val milk = 75
    override val beans = 20
    override val cost = 7
}

class Cappuccino: Coffee {
    override val water = 200
    override val milk = 100
    override val beans = 12
    override val cost = 6
}