package chapter1

/**
 * 여러 도넛을 한꺼번에 구매한다.
 *
 * 이 단계에서는 더 이상 신용카드 지급이 어떻게 이뤄지는지를 신경쓰지 않는다.
 */
fun buyDonuts(quantity: Int = 1, creditCard: CreditCard): Purchase =
    Purchase(List(quantity) { // quantity 만큼 init 한다.
        Donut()
    }, Payment(creditCard, Donut.price * quantity))


class CreditCard {
    /**
     * 이것이 이뤄지는지 신경쓰지 않음
     *
     * 지급을 즉시 처리할 수 있고, 나중에 처리하기 위해 저장할 수 있음
     * 같은 카드에 대한 처리를 한 번에 수행할 수도 있음
     */
    fun charge(price: Int) {}
}

class Donut() {
    companion object {
        const val price = 10
    }
}

class Payment(val creditCard: CreditCard, val amount: Int) {
    /**
     * 여러 Payment를 하나의 Payment로 합친다.
     *
     * @throws IllegalStateException 서로 다른 카드에 대한 Payment를 합치려고 한 경우 발생한다.
     */
    fun combine(payment: Payment): Payment =
        if (creditCard == payment.creditCard)
            Payment(creditCard, amount + payment.amount)
        else
            throw IllegalStateException("Cannot combine payments with different credit cards")

    companion object {
        /**
         * 여러 Payment 들을 creditCard 별로 합쳐준다.
         */
        fun groupByCard(payments: List<Payment>): List<Payment> =
            payments.groupBy { it.creditCard } // Map<CreditCard, List<Payment>>
                .values // Collection<List<Payment>>
                .map { it.reduce(Payment::combine) } // 각 List<Payment>를 Payment로 축약한다.
    }
}

class Purchase(val donuts: List<Donut>, val payment: Payment)
