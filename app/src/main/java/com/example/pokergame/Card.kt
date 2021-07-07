package com.example.pokergame

import java.lang.IllegalArgumentException

class Card private constructor(val number: Int, val suit: Suit) {

    companion object {
        fun create(number: Int, suit: Suit) : Card {
            if(number < 1 || number > 13) {
                throw IllegalArgumentException("invalid number $number")
            }
            return Card(number, suit)
        }
    }

    override fun toString(): String {
        return "$suit of ${getNumberString()}"
    }

    private fun getNumberString(): String {
        return when(number) {
            1 -> "Ace"
            2 -> "Two"
            3 -> "Three"
            4 -> "Four"
            5 -> "Five"
            6 -> "Six"
            7 -> "Seven"
            8 -> "Eight"
            9 -> "Nine"
            10 -> "Ten"
            11 -> "Jack"
            12 -> "Quenn"
            13 -> "King"

            else -> TODO()
        }
    }
}

enum class Suit{
    Heart, Diamond, Spade, Club
}
