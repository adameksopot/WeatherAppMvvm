package com.example.weatherappmvvm.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherappmvvm.R
import com.example.weatherappmvvm.presentation.WeatherState
import java.time.format.DateTimeFormatter

@Composable
fun WeatherCard(
    state: WeatherState,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.data?.currentWeatherData?.let { data ->
        Card(
            backgroundColor = backgroundColor,
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.align(Alignment.End),
                    text = "Today ${data.time.format(DateTimeFormatter.ofPattern("HH:mm"))}",
                    color = Color.White
                )
                Spacer(Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = data.tempC.toString(),
                    fontSize = 50.sp,
                    color = Color.White
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = data.weatherType.weatherDesc, fontSize = 20.sp,
                    color = Color.White
                )
                Spacer(Modifier.height(32.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    WeatherDataDisplay(
                        value = data.pressure.toInt(),
                        unit = "bpa",
                        icon = ImageVector.vectorResource((R.drawable.ic_pressure)),
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.toInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource((R.drawable.ic_drop)),
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.toInt(),
                        unit = "km/h",
                        icon = ImageVector.vectorResource((R.drawable.ic_wind)),
                        iconTint = Color.White,
                        textStyle = TextStyle(Color.White)
                    )
                }
            }
        }
    }
}