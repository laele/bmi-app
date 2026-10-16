package com.luissoriano.bmiapp.features.bmi.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.core.navigation.composables.AppCard
import com.luissoriano.bmiapp.ui.theme.BmiAppTheme
import com.luissoriano.bmiapp.ui.theme.PrimaryColor

@Preview
@Composable
fun GenderSection(
    modifier: Modifier = Modifier,
    isMaleSelected: Boolean = true,
    onGenderSelected: (Boolean) -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)

    ) {
       GenderCard(modifier = Modifier.weight(1f), genderText = "Male", genderSymbol = "♂", onClick = { onGenderSelected(true) }, isSelected = isMaleSelected)
        GenderCard(modifier = Modifier.weight(1f), genderText = "Female", genderSymbol = "♀", onClick = { onGenderSelected(false) }, isSelected = !isMaleSelected)
    }
}

@Preview
@Composable
fun GenderCard(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    genderText: String = "text",
    genderSymbol: String = "gender",
    onClick: () -> Unit = {}
) {
    
    val color = if(isSelected) { PrimaryColor } else { Color.Unspecified }

    AppCard(
        modifier = modifier.clickable() {
            onClick()
        },
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                genderSymbol,
                style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold),
                color = color
            )
            Text(
                genderText,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@Preview
@Composable
fun GenderCardPreview() {
    BmiAppTheme() {
        GenderCard {  }
    }

}