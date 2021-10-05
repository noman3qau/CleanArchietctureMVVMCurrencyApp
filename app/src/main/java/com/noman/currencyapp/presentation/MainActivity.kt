package com.noman.currencyapp.presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.noman.currencyapp.presentation.Screens
import com.noman.currencyapp.presentation.coindetail.CoinDetailScreen
import com.noman.currencyapp.presentation.coinlist.CoinListScreen
import com.noman.currencyapp.ui.theme.CurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author Muhammad Noman
 * Set the MainActivity to the Main Entry point for the the Dagger Hilt
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screens.CoinListScreen.route
                    ) {
                        composable(
                            route = Screens.CoinListScreen.route
                        ) {
                            CoinListScreen(this@MainActivity, navController)
                        }
                        composable(
                            route = Screens.CoinDetailScreen.route + "/{coinId}"
                        ) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}