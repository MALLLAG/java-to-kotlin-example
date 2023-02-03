package com.example.demo.marketing

import java.io.IOException
import java.io.Reader
import java.io.Writer

object HighValueCustomersReport {

    @Throws(IOException::class)
    fun generate(reader: Reader, writer: Writer) {
        val valuableCustomers = reader
            .readLines()
            .toValueCustomers()
            .sortedBy(CustomerData::score)
        writer.append("ID\tName\tSpend\n")
        for (customerData in valuableCustomers) {
            writer.appendLine(lineFor(customerData))
        }
        writer.append(valuableCustomers.summarised())
    }

    private fun List<String>.toValueCustomers() = withoutHeader()
        .map { it.toCustomerData() }
        .filter { it.score >= 10 }

    private fun List<String>.withoutHeader() = drop(1)

    private fun List<CustomerData>.summarised(): String =
        sumByDouble { it.spend }.let { total ->
            "\tTOTAL\t${total.toMoneyString()}"
        }

    fun String.toCustomerData(): CustomerData =
        split("\t").let { parts ->
            CustomerData(
                id = parts[0],
                givenName = parts[1],
                familyName = parts[2],
                score = parts[3].toInt(),
                spend = if (parts.size == 4) 0.0 else parts[4].toDouble()
            )
        }

    private fun lineFor(customerData: CustomerData): String {
        return (customerData.id + "\t" + customerData.marketingName()
                + "\t" + customerData.spend.toMoneyString())
    }

    private fun Double.toMoneyString() = this.formattedAs("%#.2f");

    private fun Any?.formattedAs(format: String) = String.format(format, this)

    private fun CustomerData.marketingName(): String = "${familyName.toUpperCase()}, $givenName"
}