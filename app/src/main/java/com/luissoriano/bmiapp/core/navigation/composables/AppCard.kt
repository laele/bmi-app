package com.luissoriano.bmiapp.core.navigation.composables


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.ui.theme.AppCard
import com.luissoriano.bmiapp.ui.theme.BmiAppTheme

@Composable
fun AppCard(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    colors: CardColors = cardColors(containerColor = AppCard),
    content: @Composable ColumnScope.() -> Unit = {}
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = shape,

        colors = colors,
    ) {
         Column(
             modifier = Modifier.padding(all = 16.dp)
         ) {
             content()
         }
    }
}

@Preview
@Composable
fun AppCardPreview() {
    BmiAppTheme() {
        AppCard(
            modifier =  Modifier.padding(16.dp),
            content = { Text("titulo") }
        )
    }

}