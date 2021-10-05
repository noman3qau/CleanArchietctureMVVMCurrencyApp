package com.noman.currencyapp.presentation.coindetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.noman.currencyapp.presentation.Screens
import com.noman.currencyapp.presentation.coindetail.components.CoinTags
import com.noman.currencyapp.presentation.coindetail.components.TeamListItem
import com.noman.currencyapp.presentation.coinlist.components.CoinListItem
import com.noman.currencyapp.presentation.coinlist.components.CoinListViewModel
import com.noman.currencyapp.presentation.coinlist.components.TopToolBar

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coinItem?.let { coinItem ->
            Column(modifier = Modifier.fillMaxWidth()) {
                TopToolBar(title = state.coinItem.name, onItemClick = {})
                /**
                 * Column to show the item as Column
                 */
                LazyColumn(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        /**
                         * Show active/inactive in a Row
                         */
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = if (coinItem.is_active) "Active" else "Inactive",
                                color = if (coinItem.is_active) Color.Green else Color.Red,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .align(CenterVertically)
                                    .weight(2f)
                            )
                        }
                        /**
                         * Next item space
                         */
                        Spacer(modifier = Modifier.height(15.dp))
                        /**
                         * Description Text
                         */
                        Text(
                            text = coinItem.description,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        /**
                         * Tags here
                         */
                        Text(
                            text = "Tags",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        FlowRow(
                            mainAxisSpacing = 10.dp,
                            crossAxisSpacing = 10.dp,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            coinItem.tags.forEach { tag ->
                                CoinTags(tag = tag.name)
                            }
                        }
                        Spacer(modifier = Modifier.height(15.dp))
                        /**
                         * Team list title
                         */
                        Text(
                            text = "Team Members",
                            style = MaterialTheme.typography.h3
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                    /**
                     * Show Team list here
                     */
                    coinItem.team?.let { teams ->
                        items(teams) { member ->
                            TeamListItem(
                                team = member, modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            )
                            /**
                             * Divider for each team member item
                             */
                            Divider()
                        }
                    }
                }
            }
        }
        /**
         * Show error message if Data fetch failed
         */
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
        /**
         * Show the progress indicator when data is loading
         */
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}