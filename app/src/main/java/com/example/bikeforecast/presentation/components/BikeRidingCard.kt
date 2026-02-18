package com.example.bikeforecast.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bikeforecast.domain.model.BikeRidingScore
import com.example.bikeforecast.domain.model.DailyForecast


@Composable
fun BikeRidingCard(
    forecast: DailyForecast,
    score: BikeRidingScore,
    viewModel:WeatherViewModel,
    isBest: Boolean
){
    val scoreColor = getScoreColor(score.score)
    val backgroundColor = if (isBest){
        Color(0xFF064E38).copy(alpha=0.3f)
    }else{
        Color(0xFF1E293B).copy(alpha = 0.8f)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isBest) Modifier.border(
                    3.dp, Color(0xFF22C55E),
                    RoundedCornerShape(20.dp),

                    )
            ),
        colors= CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        shape = RoundedCornerShape(20.dp)

    ){
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ){
                    Text(
                        text=viewModel.formatDate(forecast.date),
                        color= Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = score.recommendation.name,
                        color= scoreColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}