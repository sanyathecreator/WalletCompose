package com.example.walletapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.bytebeats.views.charts.bar.BarChart
import me.bytebeats.views.charts.bar.BarChartData
import me.bytebeats.views.charts.bar.render.label.SimpleLabelDrawer
import me.bytebeats.views.charts.bar.render.xaxis.SimpleXAxisDrawer
import me.bytebeats.views.charts.bar.render.yaxis.SimpleYAxisDrawer

@Composable
fun SpendingGraph(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = "Spending Statistics",
        fontFamily = Font(R.font.play).toFontFamily(),
        fontSize = 25.sp
    )
    Graph(modifier = modifier)
}

@Composable
fun Graph(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.height(220.dp)) {
        BarChart(
            modifier = modifier,
            barChartData = BarChartData(spendingByDay),
            xAxisDrawer = SimpleXAxisDrawer(
                axisLineThickness = 2.dp,
                axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
            ),
            yAxisDrawer = SimpleYAxisDrawer(
                labelValueFormatter = { "$ ${it.toInt()}" }, // Text near the y axis
                axisLineThickness = 2.dp,
                axisLineColor = MaterialTheme.colorScheme.onBackground.copy(0.2f)
            ),
            labelDrawer = SimpleLabelDrawer(
                // Display the dates above the charts
                drawLocation = SimpleLabelDrawer.DrawLocation.Outside,
                labelTextSize = 15.sp,
                labelTextColor = MaterialTheme.colorScheme.onBackground.copy(0.7f)
            )
        )
    }
}

val spendingByDay = listOf(
    BarChartData.Bar(
        label = "Jun 1",
        value = 123f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Jun 2",
        value = 160f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Jun 3",
        value = 204f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Jun 4",
        value = 34f,
        color = randomColor(50),
    ),
    BarChartData.Bar(
        label = "Jun 5",
        value = 74f,
        color = randomColor(50),
    )
)