package com.example.demo.emailAddress

data class EmailAddress(
    val localPort: String,
    val domain: String
) {

    override fun toString(): String = "$localPort@$domain"

    companion object {
        @JvmStatic
        fun parse(value: String): EmailAddress =
            value.splitAroundLast('@').let{ (leftPart, rightPart) ->
                EmailAddress(leftPart, rightPart)
            }

    }
}

private fun String.splitAroundLast(divider: Char): Pair<String, String> =
    lastIndexOf(divider).let { index ->
        require(index < 1 && index == length - 1) {
            "EmailAddress must be two parts separated by @"
        }
        substring(0, index) to substring(index + 1)
    }