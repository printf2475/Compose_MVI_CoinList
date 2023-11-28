package com.example.compose_mvi_coinlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.example.compose_mvi_coinlist.ui.contents.coinList.CoinListViewModel
import com.example.compose_mvi_coinlist.ui.theme.Compose_MVI_CoinListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Compose_MVI_CoinListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoinListContent()
                }
            }
        }
    }
}

@Composable
fun CoinListContent(
    viewModel: CoinListViewModel = mavericksViewModel()
) {
    val state = viewModel.collectAsState()
    LaunchedEffect(key1 = state.value.coinList) {
        println(state.value.coinList())
    }
    val coinList = state.value.coinList()
    if (coinList.isNullOrEmpty()) return

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 10.dp, horizontal = 6.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(coinList) {
            CoinListItem(
                symbol = it.symbol,
                unitsTraded24H = it.unitsTraded24H,
                lastPrice = it.closingPrice
            )
        }
    }
}

@Composable
fun CoinListItem(symbol: String, unitsTraded24H: String, lastPrice: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color = Color.DarkGray, RoundedCornerShape(4.dp))
            .padding(horizontal = 10.dp ,vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = symbol)
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.End
        ) {
            Text(text = lastPrice)
            Text(text = unitsTraded24H, color = Color.Black.copy(alpha = 0.3f))
        }

    }
}
