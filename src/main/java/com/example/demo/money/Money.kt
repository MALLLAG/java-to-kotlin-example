package com.example.demo.money

import java.math.BigDecimal
import java.util.*

data class Money
private constructor(
    val amount: BigDecimal,
    val currency: Currency
) {

    override fun equals(other: Any?) =
        this === other ||
                other is Money &&
                amount == other.amount &&
                currency == other.currency

    override fun hashCode() =
        Objects.hash(amount, currency)

    override fun toString() =
        amount.toString() + " " + currency.currencyCode

    fun add(that: Money): Money = this + that

    operator fun plus(that: Money): Money {
        require(currency == that.currency) {
            "cannot add Money values of different currencies"
        }
        return Money(amount.add(that.amount), currency)
    }

    companion object {
        @JvmStatic
        fun of(amount: BigDecimal, currency: Currency) =
            this(amount, currency)

        operator fun invoke(amount: BigDecimal, currency: Currency) =
            Money(
                amount.setScale(currency.defaultFractionDigits),
                currency
            )
        }
}