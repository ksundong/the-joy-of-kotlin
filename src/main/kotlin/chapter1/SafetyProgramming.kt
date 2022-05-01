package chapter1

/**
 * 이 단계에서는 더 이상 신용카드 지급이 어떻게 이뤄지는지를 신경쓰지 않는다.
 */
fun buyDonut(creditCard: CreditCard): Purchase {
    val donut = Donut()
    val payment = Payment(creditCard, donut.price)
    return Purchase(donut, payment)
}

class CreditCard {
    /**
     * 이것이 이뤄지는지 신경쓰지 않음
     *
     * 지급을 즉시 처리할 수 있고, 나중에 처리하기 위해 저장할 수 있음
     * 같은 카드에 대한 처리를 한 번에 수행할 수도 있음
     */
    fun charge(price: Int) {}
}

class Donut(val price: Int = 10)

class Payment(val creditCard: CreditCard, val amount: Int)

class Purchase(val donut: Donut, val payment: Payment)
