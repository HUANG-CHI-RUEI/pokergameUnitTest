package com.example.pokergame

import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class CalculatorTest {

    @Test
    fun addOne() {
        //Arrange
        val input = 3
        val expect = 4
        val calculator = Calculator()
        //Act 
        val result = calculator.addOne(input)
        //Assert
        Assert.assertEquals(expect, result)
    }
}