package com.noman.currencyapp.presentation.coinlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.noman.currencyapp.data.remote.datatransobject.CoinDto


@Composable
fun CoinListItem(
    coinDto: CoinDto,
    onItemClick: (CoinDto) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coinDto) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween)
    {

        Text(
            text = "${coinDto.rank}. ${coinDto.name} (${coinDto.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = if (coinDto.is_active) "Active" else "Inactive",
            color = if (coinDto.is_active) androidx.compose.ui.graphics.Color.Green else androidx.compose.ui.graphics.Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )


    }

}