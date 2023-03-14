package com.example.weatherappmvvm.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherappmvvm.domain.model.WeatherData
import com.example.weatherappmvvm.presentation.WeatherState
import com.example.weatherappmvvm.ui.theme.DarkBlue
import com.example.weatherappmvvm.ui.theme.DeepBlue
import com.example.weatherappmvvm.ui.theme.WeatherAppMvvmTheme
import com.example.weatherappmvvm.util.WeatherTestData
import java.time.format.DateTimeFormatter

@Composable
fun weatherForecast(state: WeatherState, modifier: Modifier = Modifier, backgroundColor: Color) {
    state.data?.weatherDataForADay?.get(0)?.let {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),

            ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(items = it, itemContent = { SingleForecast(it, backgroundColor) })
            }
        }
    }
}

@Composable
fun SingleForecast(
    data: WeatherData, backgroundColor: Color,
) {
    Card(backgroundColor = Color.Red) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(10.dp).background(backgroundColor)) {
            Text(color = Color.White, text = data.time.format(DateTimeFormatter.ofPattern("HH:mm")))
            Image(
                modifier = Modifier.width(40.dp).height(50.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = data.weatherType.iconRes),
                contentDescription = null,
            )
            Text(text = data.tempC.toString() + "\u2103", color = Color.White)
        }
    }
}


@Composable
@Preview
fun preview() {
    val data = WeatherTestData()
    val singleData = data.data
    WeatherAppMvvmTheme {
        SingleForecast(data = singleData, backgroundColor = DeepBlue)
    }
}
