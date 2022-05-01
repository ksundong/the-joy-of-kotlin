package chapter1

fun buyDonut(creditCard: CreditCard): Donut { // need to mock CreditCard
    val donut = Donut()
    creditCard.charge(donut.price) // side-effect
    return donut
}

class CreditCard {
    fun charge(price: Double) {}
}

class Donut(val price: Double = 10.0)
