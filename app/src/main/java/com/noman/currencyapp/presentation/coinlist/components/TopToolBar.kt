package com.noman.currencyapp.presentation.coinlist.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noman.currencyapp.data.remote.datatransobject.CoinDto

@Composable
fun TopToolBar(
    title: String,
    onItemClick: (String) -> Unit
) {

    TopAppBar(
        title = {
            Text(text = title)
        },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(
                onClick = {
                    onItemClick("Clicked on Navigation Icon")
                }) {
                Icon(Icons.Filled.Menu, "Navigation Menu Icon")
            }
        },
        actions = {

        }
    )

}