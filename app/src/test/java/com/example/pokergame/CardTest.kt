package com.example.pokergame

import org.junit.Assert
import org.junit.Test
import java.lang.IllegalArgumentException

class CardTest {
    @Test
    fun verifyHeartAce() {
        // Arrange
        val card = Card.create(1, Suit.Heart)
        val expect = "Heart of Ace"
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(expect, result)
    }

    @Test
    fun verifyHeartTwo() {
        // Arrange
        val card = Card.create(2, Suit.Heart)
        val expect = "Heart of Two"
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(expect, result)
    }

    @Test
    fun `14 heart should not be able to created`() {
        // Arrange
        var hasException = false
        try {
            val card = Card.create(14, Suit.Heart)

        }catch (e: IllegalArgumentException) {
            hasException = true
        }
        // Assert
        Assert.assertTrue(hasException)
    }

    @Test
    fun verifyDiamondTwo() {
        // Arrange
        val card = Card.create(2, Suit.Diamond)
        val expect = "Diamond of Two"
        // Act
        val result = card.toString()
        // Assert
        Assert.assertEquals(expect, result)
    }
}