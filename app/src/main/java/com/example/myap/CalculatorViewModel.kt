package com.example.myap

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel(){
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(actions: CalculatorActions) {
        when(actions) {
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(actions.calculatorOperations)
            is CalculatorActions.Calculate -> performCalculation()
            is CalculatorActions.Delete -> performDeletion()
        }
    }

    private fun performDeletion(){
        when {
            state.num2.isNotBlank() -> state = state.copy(num2 = state.num2.dropLast(1))
            state.operations !=null -> state = state.copy(operations = null)
            state.num1.isNotBlank() -> state = state.copy(num1 = state.num1.dropLast(1))
        }
    }

    private fun performCalculation() {
        val number1 = state.num1.toDoubleOrNull();
        val number2 = state.num2.toDoubleOrNull();
        if(number2!=null && number1!=null) {
            val result = when(state.operations) {
                is CalculatorOperations.Add -> number1 + number2
                is CalculatorOperations.Subtract -> number1-number2
                is CalculatorOperations.Multiply -> number1*number2
                is CalculatorOperations.Divide -> number1/number2
                else -> null
            }
            if(result == null){

            }
            if(!state.num2.contains('.') && !state.num1.contains('.') && result != null) {
                    state = state.copy(
                        num1 = result.toInt().toString().take(14),
                        num2 = "",
                        operations = null
                    )

            }
            else {
                state = state.copy(
                    num1 = result.toString().take(8),
                    num2 = "",
                    operations = null
                )
            }
        }
    }

    private fun enterOperation(calculatorOperations: CalculatorOperations) {
        if(state.num1.isNotBlank())     state = state.copy(operations = calculatorOperations)
    }

    private fun enterDecimal() {
        if(state.operations == null && !state.num1.contains(".") && state.num1.isNotBlank())  {
            state = state.copy(num1 = state.num1+".")
        }
        if(state.operations!=null && !state.num2.contains(".") && state.num2.isNotBlank())  {
            state = state.copy(num2 = state.num2+".")
        }
    }

    private fun enterNumber(number: Int) {
        Log.d("jkjk", number.toString())
        if(state.operations == null && state.num1.length <6) {
            state = state.copy(num1 = state.num1 + number);
        }
        if(state.operations != null && state.num2.length <6) {
            state = state.copy(num2 = state.num2 + number);
        }
    }
}



