package com.noman.currencyapp.presentation.coinlist

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.noman.currencyapp.presentation.Screens
import com.noman.currencyapp.presentation.coinlist.components.CoinListItem
import com.noman.currencyapp.presentation.coinlist.components.CoinListViewModel
import com.noman.currencyapp.presentation.coinlist.components.TopToolBar

@Composable
fun CoinListScreen(
    context: Context,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Column(modifier = Modifier.fillMaxWidth()) {
        TopToolBar(
            "Currency App",
            onItemClick = {
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
        )
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.coinList) { coinItem ->
                    CoinListItem(
                        coinDto = coinItem,
                        onItemClick = {
                            navController.navigate(Screens.CoinDetailScreen.route + "/${coinItem.id}")
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}