package com.example.walletapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardSection(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // A piece of card behind main card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(100.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Green, Color.Yellow)
                    )
                )
        )

        // Main card
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
                .padding(horizontal = 22.dp, vertical = 10.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            CardContent(
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun CardContent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.error
                    )
                )
            )
    ) {
        // World icon
        Icon(
            painter = painterResource(id = R.drawable.world),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background.copy(0.1f),
            modifier = Modifier
                .fillMaxSize()
                .offset(150.dp, 80.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "My balance",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.6f),
                fontFamily = Font(R.font.play).toFontFamily(),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$4.228.52",
                color = MaterialTheme.colorScheme.onPrimary,
                fontFamily = Font(R.font.play).toFontFamily(),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
                .align(Alignment.BottomCenter),
            // Content is pushed as far from each other as possible
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "* * * * 1337",
                color = MaterialTheme.colorScheme.onPrimary.copy(0.8f),
                fontSize = 23.sp,
                fontFamily = Font(R.font.play).toFontFamily()
            )

            Icon(
                painter = painterResource(id = R.drawable.visa),
                contentDescription = null,
                modifier = Modifier.width(100.dp),
                tint = MaterialTheme.colorScheme.background
            )
        }
    }
}