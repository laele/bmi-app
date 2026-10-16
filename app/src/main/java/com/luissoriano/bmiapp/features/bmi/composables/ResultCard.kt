package com.luissoriano.bmiapp.features.bmi.composables


import android.util.Range
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Accessibility
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.core.navigation.composables.AppCard
import com.luissoriano.bmiapp.ui.theme.BmiAppTheme
import com.luissoriano.bmiapp.ui.theme.PrimaryColor
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.luissoriano.bmiapp.ui.theme.OnPrimaryColor


fun checkBmi(bmi : Double, range: ClosedRange<Double>) : Boolean {
    if( bmi in range) { return true } else {return false}
}

@Composable
fun ResultCard(
    modifier: Modifier = Modifier,
    bmi: Double,
) {
    AppCard(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                BmiIndicatorItem(modifier = Modifier.weight(1f), title = "Underweight", bmiRange = "BMI < 18.4", isSelected = checkBmi(bmi = bmi, range = Double.MIN_VALUE..18.4))
                BmiIndicatorItem(modifier = Modifier.weight(1f), title = "Healty", bmiRange = "BMI 18.5 - 24.9", isSelected = checkBmi(bmi = bmi, range = 18.5..24.9))
                BmiIndicatorItem(modifier = Modifier.weight(1f), title = "Overweight", bmiRange = "BMI 25 - 29.9", isSelected = checkBmi(bmi = bmi, range = 25.0..29.9))
                BmiIndicatorItem(modifier = Modifier.weight(1f), title = "Obese", bmiRange = "BMI 30 - 39.9", isSelected = checkBmi(bmi = bmi, range = 30.0..39.9))
                BmiIndicatorItem(modifier = Modifier.weight(1f), title = "Severely Obese", bmiRange = "BMI 40 >", isSelected = checkBmi(bmi = bmi, range = 40.0..Double.MAX_VALUE))
            }
        }
    }
}

@Preview
@Composable
fun ResultCardPreview() {
    BmiAppTheme() {
        ResultCard(
            bmi = 20.0,
        )
    }
}

@Preview
@Composable
fun BmiIndicatorItem(
    modifier: Modifier = Modifier,
    title: String = "title",
    bmiRange: String = "bmi-range",
    icon: ImageVector = Icons.Default.Accessibility,
    isSelected: Boolean = false,
) {
    val color = if(isSelected) { PrimaryColor } else { Color.Unspecified }
    val iconColor = if(isSelected) { OnPrimaryColor } else { Color.Unspecified }
    Box(modifier = modifier.background(color = color, shape = RoundedCornerShape(12.dp)).padding(4.dp)) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = icon, contentDescription = "", tint = iconColor)
            Text(title, style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold, color = iconColor), maxLines = 1)
            Text(bmiRange, style = MaterialTheme.typography.labelSmall.copy(color = iconColor), maxLines = 2, textAlign = TextAlign.Center)
        }
    }
}