package com.luissoriano.bmiapp.features.bmi.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.features.bmi.composables.GenderSection
import com.luissoriano.bmiapp.features.bmi.composables.HeightSelectorSection
import com.luissoriano.bmiapp.features.bmi.composables.ResultCard
import com.luissoriano.bmiapp.features.bmi.composables.WeigthAgeSection
import com.luissoriano.bmiapp.ui.theme.AppBackground
import com.luissoriano.bmiapp.ui.theme.OnPrimaryColor
import com.luissoriano.bmiapp.ui.theme.PrimaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onBmiCalculatePressed: (Double) -> Unit) {

    var height: Float by rememberSaveable() { mutableStateOf(value = 90f)}
    var isMaleSelected: Boolean by rememberSaveable() { mutableStateOf(value = true)}
    var weight: Double by rememberSaveable() { mutableStateOf(value = 90.0) }
    var age: Int by rememberSaveable() { mutableStateOf(value = 30) }

    val scrollState = rememberScrollState()

    fun calculateBmi(): Double {
        val heightInMeters = height / 100
        return (weight  / (heightInMeters * heightInMeters))
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("BMI Calculator", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) }) },
        containerColor = AppBackground,
        floatingActionButton = { FloatingActionButton(  onClick = { onBmiCalculatePressed(calculateBmi()) }, containerColor = PrimaryColor, contentColor = OnPrimaryColor) { Icon(imageVector = Icons.Default.Scale, contentDescription = "") }}
    ) {
        paddingValues ->
        Column(
            modifier  = Modifier.padding(paddingValues).padding(16.dp).verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
            GenderSection(
                onGenderSelected = { isMaleSelected = !isMaleSelected },
                isMaleSelected = isMaleSelected,
            )
            HeightSelectorSection(value = height, onValueChanged = { height = it })
            WeigthAgeSection(
                weightValue = " ${weight} kg",
                onMinusWeightPressed = { weight -= 0.5 },
                onAddWeightPressed = { weight += 0.5 },
                ageValue = age.toString(),
                onMinusAgePressed = { age -= 1},
                onAddAgePressed = {  age += 1 },
            )
            Column() {
                Text(String.format("%.2f", calculateBmi()), style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold) )
                Text("Current BMI", style = MaterialTheme.typography.titleLarge)
                Spacer( modifier = Modifier.height(16.dp))
            }
            ResultCard(bmi = calculateBmi())

        }
    }
}