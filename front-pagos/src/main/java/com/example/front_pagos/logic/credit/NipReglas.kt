package com.example.front_pagos.logic.credit


data class NipRules(
    val hasSixDigits: Boolean = false,
    val noConsecutiveNumbers: Boolean = false,
    val noRepeatedNumbers: Boolean = false
) {
    fun allRulesValid() = hasSixDigits && noConsecutiveNumbers && noRepeatedNumbers

    companion object {

        fun validateSixDigits(nip: String): Boolean {
            return nip.length == 6 && nip.all { it.isDigit() }
        }

        fun validateNoConsecutiveNumbers(nip: String): Boolean {
            if (nip.length < 2) return true
            for (i in 0 until nip.length - 1) {
                val current = nip[i].digitToIntOrNull() ?: return false
                val next = nip[i + 1].digitToIntOrNull() ?: return false
                if (Math.abs(current - next) == 1) {
                    return false
                }
            }
            return true
        }

        fun validateNoRepeatedNumbers(nip: String): Boolean {
            return nip.toSet().size == nip.length
        }
    }
}