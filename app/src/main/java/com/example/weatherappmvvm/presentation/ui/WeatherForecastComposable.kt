package com.example.weatherappmvvm.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappmvvm.domain.model.WeatherData
import com.example.weatherappmvvm.presentation.WeatherState
import java.time.format.DateTimeFormatter

@Composable
fun WeatherForecast(state: WeatherState, modifier: Modifier = Modifier, backgroundColor: Color) {
    state.data?.weatherDataForADay?.get(0)?.let {
        Text(
            modifier = Modifier.padding(start = 16.dp), text =
            "Today", color = Color.LightGray, fontSize = 15.sp
        )
        Card(
            backgroundColor = backgroundColor,
            modifier = Modifier.padding(16.dp), shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),

                ) {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(items = it, itemContent = { SingleForecast(it, modifier) })
                }
            }
        }
    }
}

@Composable
fun SingleForecast(
    weatherData: WeatherData,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White
) {
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = Color.LightGray
        )
        Image(
            contentScale = ContentScale.Inside,
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
        )
        Text(
            text = "${weatherData.tempC}°C",
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}

