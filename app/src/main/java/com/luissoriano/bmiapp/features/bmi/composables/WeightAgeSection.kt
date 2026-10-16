package com.luissoriano.bmiapp.features.bmi.composables

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.core.navigation.composables.AppCard
import com.luissoriano.bmiapp.ui.theme.AppCard
import com.luissoriano.bmiapp.ui.theme.BmiAppTheme
import com.luissoriano.bmiapp.ui.theme.OnPrimaryColor
import com.luissoriano.bmiapp.ui.theme.PrimaryColor


@Preview
@Composable
fun WeigthAgeSection(
    onMinusWeightPressed: () -> Unit = {},
    onAddWeightPressed: () -> Unit = {},
    onMinusAgePressed: () -> Unit = {},
    onAddAgePressed: () -> Unit = {},
    weightValue: String = "value",
    ageValue: String = "value",
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        CounterCard(modifier = Modifier.weight(1f), title = "Weight", onMinusPressed = { onMinusWeightPressed() }, onAddPressed = { onAddWeightPressed() }, value = weightValue)
        CounterCard(modifier = Modifier.weight(1f), title = "Age", onMinusPressed = { onMinusAgePressed() }, onAddPressed = { onAddAgePressed() }, value = ageValue,)
    }
}

@Preview
@Composable
fun CounterCard(
    modifier: Modifier = Modifier,
    title: String = "title",
    value: String = "value",
    onAddPressed: () -> Unit = {},
    onMinusPressed: () -> Unit = {},

) {
    AppCard(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(title, style = MaterialTheme.typography.titleLarge)
            Text(value, style = MaterialTheme.typography.headlineLarge.copy(fontWeight = FontWeight.Bold))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                IconButton(
                    onClick = { onMinusPressed() },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = PrimaryColor, contentColor = OnPrimaryColor)
                ) {
                    Icon(imageVector = Icons.Default.Remove, contentDescription = "")
                }
                IconButton(
                    onClick = { onAddPressed() },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = PrimaryColor, contentColor = OnPrimaryColor)
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
            }
        }
    }
}

@Preview
@Composable
fun CounterCardPreview() {
    BmiAppTheme() {
        CounterCard()
    }
}