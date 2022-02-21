package com.test.rickandmorty.presentation.ui.episode_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.rickandmorty.presentation.components.EpisodeCard

@Composable
fun EpisodeScreen(
    navController: NavController,
    viewModel: EpisodeViewModel = hiltViewModel()
) {

    val loading = viewModel.loading.value
    val episodes = viewModel.episodes.value
    val episodesLastIndex = viewModel.episodesLastIndex.value

    val lazyListState = rememberLazyListState()

    lazyListState.firstVisibleItemIndex.let {
        if (!loading && it > episodesLastIndex) {
            viewModel.onTriggerEvent(EpisodeEvent.NextPage)
        }
    }


    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {}
    ) {

        if (loading) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                state = lazyListState,
                modifier = Modifier.fillMaxWidth(),
                contentPadding = it
            ) {
                itemsIndexed(items = episodes) { _, item ->
                    EpisodeCard(item = item)
                }
            }
        }
    }
}