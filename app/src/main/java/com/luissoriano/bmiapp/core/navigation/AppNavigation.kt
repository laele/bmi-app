package com.luissoriano.bmiapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.luissoriano.bmiapp.features.bmi.screens.BmiResultScreen
import com.luissoriano.bmiapp.features.bmi.screens.HomeScreen

@Composable
fun AppNavigation() {
    val backStack = rememberNavBackStack(Home)
    NavDisplay(
        backStack = backStack,
        entryProvider =  entryProvider {
            entry<Home> {
                HomeScreen(onBmiCalculatePressed= { backStack.add(BMIResult)})
            }
            entry <BMIResult> {
                BmiResultScreen(onGoBackPressed = { backStack.removeLastOrNull() })
            }
        }
    )
}