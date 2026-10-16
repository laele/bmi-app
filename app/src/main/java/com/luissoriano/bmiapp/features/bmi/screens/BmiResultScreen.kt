package com.luissoriano.bmiapp.features.bmi.screens

import android.R
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.luissoriano.bmiapp.core.navigation.BMIResult
import com.luissoriano.bmiapp.features.bmi.composables.ResultCard
import com.luissoriano.bmiapp.ui.theme.AppBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmiResultScreen(onGoBackPressed: () -> Unit, bmi: Double) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = AppBackground,
        topBar = {
            TopAppBar(
                navigationIcon = { IconButton(onClick = { onGoBackPressed() }) {
                    Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "")
                } },
                title = {
                    Text(
                        "BMI Calculator Result",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            )
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            Text(String.format("%.2f", bmi), style = MaterialTheme.typography.displayLarge.copy(fontWeight = FontWeight.Bold) )
            Text("Current BMI", style = MaterialTheme.typography.titleLarge)
            Spacer( modifier = Modifier.height(16.dp))
            ResultCard(bmi = bmi)
        }
    }
}