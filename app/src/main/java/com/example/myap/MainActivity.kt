package com.example.myap

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myap.ui.theme.LightGray
import com.example.myap.ui.theme.MyApTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                Log.d("kjjk",state.toString())
                val buttonSpacing = 8.dp
                Calculator(state = state, onActions = viewModel::onAction, buttonSpacing = buttonSpacing,
                    modifier = Modifier.fillMaxSize().background(Color.LightGray).padding(16.dp)
                )

            }
        }
    }
}
