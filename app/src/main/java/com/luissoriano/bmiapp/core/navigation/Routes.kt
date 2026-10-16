package com.luissoriano.bmiapp.core.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Home: NavKey

@Serializable
data class BMIResult(val bmi: Double) : NavKey