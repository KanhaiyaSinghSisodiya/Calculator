package com.example.myap

data class CalculatorState(
    val num1: String = "",
    val num2: String = "",
    val operations: CalculatorOperations? = null
)