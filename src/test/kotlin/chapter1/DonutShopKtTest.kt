package chapter1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class DonutShopKtTest {

    @Test
    fun testBuyDonuts() {
        // given
        val creditCard = CreditCard()

        // when
        val purchase = buyDonuts(5, creditCard)

        // then
        assertAll(
            { assertThat(purchase.payment.amount).isEqualTo(Donut.price * 5) },
            { assertThat(purchase.payment.creditCard).isEqualTo(creditCard) },
        )
    }
}
