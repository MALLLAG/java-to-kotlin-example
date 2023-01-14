package com.example.demo.emailAddress

data class EmailAddress(val localPort: String, val domain: String) {

    override fun toString(): String {
        return "$localPort@$domain"
    }

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress {
            val atIndex = value.lastIndexOf('@')
            if (atIndex < 1 || atIndex == value.length - 1) {
                throw IllegalAccessException(
                    "EmailAddress must be two parts separated by @"
                )
            }
            return EmailAddress(
                value.substring(0, atIndex),
                value.substring(atIndex + 1)
            )
        }
    }
}