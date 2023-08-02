package com.example.myap

import android.service.autofill.OnClickAction
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myap.components.CustomButton
import com.example.myap.ui.theme.LightGray
import com.example.myap.ui.theme.Orange
import com.example.myap.ui.theme.Purple40

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp ,
    modifier: Modifier = Modifier,
    onActions: (CalculatorActions) -> Unit
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(text = state.num1 + (state.operations?.symbol?:"")+state.num2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.White,
                maxLines = 2
            )
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CustomButton(symbol = "AC", modifier = Modifier.background(LightGray).aspectRatio(2f).weight(2f),
                    onClick = {
                        onActions(CalculatorActions.Clear)
                    }
                )
                CustomButton(symbol = "Del", modifier = Modifier.background(LightGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Delete)
                    }
                )
                CustomButton(symbol = "/", modifier = Modifier.background(Purple40).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperations.Divide))
                    }
                )
            }
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CustomButton(symbol = "7", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(7))
                    }
                )
                CustomButton(symbol = "8", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(8))
                    }
                )
                CustomButton(symbol = "9", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(9))
                    }
                )
                CustomButton(symbol = "x", modifier = Modifier.background(Purple40).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperations.Multiply))
                    }
                )
            }
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CustomButton(symbol = "4", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(4))
                    }
                )
                CustomButton(symbol = "5", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(5))
                    }
                )
                CustomButton(symbol = "6", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(6))
                    }
                )
                CustomButton(symbol = "-", modifier = Modifier.background(Purple40).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperations.Subtract))
                    }
                )
            }
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CustomButton(symbol = "1", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(1))
                    }
                )
                CustomButton(symbol = "2", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(2))
                    }
                )
                CustomButton(symbol = "3", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Number(3))
                    }
                )
                CustomButton(symbol = "+", modifier = Modifier.background(Purple40).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Operation(CalculatorOperations.Add))
                    }
                )
            }
            Row(Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)) {
                CustomButton(symbol = "0", modifier = Modifier.background(Color.DarkGray).aspectRatio(2f).weight(2f),
                    onClick = {
                        onActions(CalculatorActions.Number(0))
                    }
                )
                CustomButton(symbol = ".", modifier = Modifier.background(Color.DarkGray).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Decimal)
                    }
                )
                CustomButton(symbol = "=", modifier = Modifier.background(Purple40).aspectRatio(1f).weight(1f),
                    onClick = {
                        onActions(CalculatorActions.Calculate )
                    }
                )
            }
        }
    }
}