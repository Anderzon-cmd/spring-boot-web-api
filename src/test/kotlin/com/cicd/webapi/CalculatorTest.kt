package com.cicd.webapi

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class CalculatorTest {
    @Test
    fun testAdd() {
        val calculator = Calculator()
        assert(calculator.add(2, 3) == 5)
    }

    @Test
    fun testSubtract() {
        val calculator = Calculator()
        assert(calculator.subtract(5, 3) == 2)
    }

    @Test
    fun testMultiply() {
        val calculator = Calculator()
        assert(calculator.multiply(2, 3) == 6)
    }

    @Test
    fun testDivide() {
        val calculator = Calculator()
        assert(calculator.divide(6.0, 3.0) == 2.0)

        val exception: IllegalArgumentException = assertThrows(
            IllegalArgumentException::class.java
        ) {
            calculator.divide(10.0, 0.0)
        }

        println("Error message: ${exception.message}")

        assert(exception.message.equals("Cannot divide by zero"))
    }
}