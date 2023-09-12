package machine

class CoffeeMachine {
    private var water = 400
    private var milk = 540
    private var beans = 120
    private var money = 550
    var cups = 9
        private set

    fun contentsString():  String {
        return """|
            |The coffee machine has:
            |$water ml of water
            |$milk ml of milk
            |$beans g of coffee beans
            |$cups disposable cups
            |$$money of money""".trimMargin()
    }

    fun enoughWater(coffee: Coffee): Boolean = water - coffee.water >= 0

    fun enoughMilk(coffee: Coffee): Boolean = milk - coffee.milk >= 0

    fun enoughBeans(coffee: Coffee): Boolean = beans - coffee.beans >= 0

    fun buy(coffee: Coffee) {
        water -= coffee.water
        milk -= coffee.milk
        beans -= coffee.beans
        cups--
        money += coffee.cost
    }

    fun fill(water: Int, milk: Int, beans: Int, cups: Int) {
        this.water += water
        this.milk += milk
        this.beans += beans
        this.cups += cups
    }

    fun take(): Int {
        val taken = money
        money = 0
        return taken
    }
}

enum class Coffee(val water: Int = 0, val milk: Int = 0, val beans: Int = 0, val cost: Int = 0) {
    ESPRESSO(water = 250, beans = 16, cost = 4),
    LATTE(water = 350, milk = 75, beans = 20, cost = 7),
    CAPPUCCINO(water = 200, milk = 100, beans = 12, cost = 6)
}

