package com.example.walletapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCard
import androidx.compose.material.icons.rounded.Healing
import androidx.compose.material.icons.rounded.Restaurant
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.toFontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpendingSection(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(horizontal = 22.dp),
        text = "Spending Breakdown",
        fontFamily = Font(R.font.play).toFontFamily(),
        fontSize = 25.sp
    )
    Spacer(modifier = Modifier.run { height(16.dp) })
    SpendingList(modifier = modifier)
}

@Composable
fun SpendingList(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        itemsIndexed(spendingItems) { index, spendingItem ->
            SpendingItem(spendingItem = spendingItem)
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}

@Composable
fun SpendingItem(
    modifier: Modifier = Modifier,
    spendingItem: SpendingItem
) {
    ElevatedCard(
        modifier = modifier.size(150.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) // Items still bright even when dark theme is turned on
                .background(spendingItem.color.copy(0.5f))
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = spendingItem.icon,
                contentDescription = spendingItem.name,
                tint =  Color.Black.copy(0.8f),
                modifier = Modifier.size(33.dp)
            )

            Text(
                text = spendingItem.name,
                fontSize = 15.sp,
                color = Color.Black.copy(0.7f)
            )

            Text(
                text = "$" + spendingItem.amount.toString(),
                fontSize = 20.sp,
                color = Color.Black,
                fontFamily = Font(R.font.play).toFontFamily()
            )
        }
    }
}

val spendingItems = listOf(
    SpendingItem(
        name = "Food",
        amount = 133.7f,
        color = randomColor(),
        icon = Icons.Rounded.Restaurant
    ),
    SpendingItem(
        name = "Shopping",
        amount = 144f,
        color = randomColor(),
        icon = Icons.Rounded.ShoppingCart
    ),
    SpendingItem(
        name = "Subscriptions",
        amount = 52f,
        color = randomColor(),
        icon = Icons.Rounded.AddCard
    ),
    SpendingItem(
        name = "Health",
        amount = 228f,
        color = randomColor(),
        icon = Icons.Rounded.Healing
    )
)

data class SpendingItem(
    val name: String,
    val amount: Float,
    val color: Color,
    val icon: ImageVector
)