package com.example.pokergame

import org.junit.Assert
import org.junit.Test

class HandTest {
    @Test
    fun `H1 H3 H5 H6 H7 should be Flush`() {
        val card = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Heart),
            Card.create(5, Suit.Heart),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Heart)
            )

        val hand = Hand(card)
        val expectedCategory = RankingCategory.Flush
        // act
        val category = hand.getCategory()
        // assert
        Assert.assertEquals(expectedCategory, category)
    }

    @Test
    fun `H1 C3 S5 H6 D7 should be Flush`() {
        val card = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Club),
            Card.create(5, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Diamond)
        )

        val hand = Hand(card)
        val expectedCategory = RankingCategory.Highcard
        // act
        val category = hand.getCategory()
        // assert
        Assert.assertEquals(expectedCategory, category)
    }

    @Test
    fun `H1 C1 S1 H6 D6 should be Full House`() {
        val card = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(6, Suit.Diamond)
        )

        val hand = Hand(card)
        val expectedCategory = RankingCategory.FullHouse
        // act
        val category = hand.getCategory()
        // assert
        Assert.assertEquals(expectedCategory, category)
    }

    @Test
    fun `H1 C1 S1 H1 D6 should be Four of a kind`() {
        val card = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(1, Suit.Heart),
            Card.create(6, Suit.Diamond)
        )

        val hand = Hand(card)
        val expectedCategory = RankingCategory.FourOfAKind
        // act
        val category = hand.getCategory()
        // assert
        Assert.assertEquals(expectedCategory, category)
    }

    @Test
    fun `flush should win Full house`() {
        // Arrange
        val cards = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(6, Suit.Diamond)
        )

        val flushCards = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Club),
            Card.create(5, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Diamond)
        )

        val fullHouseHand = Hand(cards)
        val flushHand = Hand(flushCards)

        // Act
        val wins = fullHouseHand.wins(flushHand)

        // Assert
        Assert.assertTrue(wins)
    }

    @Test
    fun `Full house should win flush`() {
        // Arrange
        val cards = listOf(
            Card.create(1, Suit.Heart),
            Card.create(1, Suit.Club),
            Card.create(1, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(6, Suit.Diamond)
        )

        val flushCards = listOf(
            Card.create(1, Suit.Heart),
            Card.create(3, Suit.Club),
            Card.create(5, Suit.Spade),
            Card.create(6, Suit.Heart),
            Card.create(7, Suit.Diamond)
        )

        val fullHouseHand = Hand(cards)
        val flushHand = Hand(flushCards)

        // Act
        val wins = flushHand.wins(fullHouseHand)

        // Assert
        Assert.assertFalse(wins)
    }
}