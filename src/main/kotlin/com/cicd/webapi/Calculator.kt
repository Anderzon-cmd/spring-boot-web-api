package com.cicd.webapi

class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Double, b: Double): Double{
        if (b==0.0){
            throw IllegalArgumentException("Cannot divide by zero")
        }

        return a/b
    }

    fun factorial(n: Int): Long {
        if (n < 0) {
            throw IllegalArgumentException("Cannot calculate factorial of negative numbers")
        }
        return if (n == 0) 1 else n * factorial(n - 1)
    }
}