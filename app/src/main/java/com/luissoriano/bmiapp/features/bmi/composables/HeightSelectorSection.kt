package com.luissoriano.bmiapp.features.bmi.composables



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.luissoriano.bmiapp.core.navigation.composables.AppCard

import com.luissoriano.bmiapp.ui.theme.BmiAppTheme
import com.luissoriano.bmiapp.ui.theme.PrimaryColor

@Preview
@Composable
fun HeightSelectorSection(
    onValueChanged: (Float) -> Unit = {},
    value: Float = 90f,
) {
    BmiAppTheme() {
        HeightSelector(value = value, onValueChanged = onValueChanged,)
    }
}

@Composable
fun HeightSelector(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChanged: (Float) -> Unit = {}
){
    AppCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Height", style = MaterialTheme.typography.titleLarge)
            Text("${value.toInt()} cm", style = MaterialTheme.typography.displayLarge.copy(fontWeight =  FontWeight.Bold))
            Slider(
                value = value,
                valueRange = 50f..250f,
                onValueChange = {it -> onValueChanged(it)},
                colors = SliderDefaults.colors(
                    activeTrackColor = PrimaryColor,
                    thumbColor = PrimaryColor,
                )
            )
        }
    }
}

