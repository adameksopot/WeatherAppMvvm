package com.example.weatherappmvvm.presentation.ui

import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun WeatherDetails(onBack: () -> Unit) {
    Text("Details", modifier = Modifier.fillMaxSize().background(Color.LightGray))

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        BackHandlerTiramisu(true) {
            onBack()
        }
    } else {
        BackHandler {
            onBack()
        }
    }
}
