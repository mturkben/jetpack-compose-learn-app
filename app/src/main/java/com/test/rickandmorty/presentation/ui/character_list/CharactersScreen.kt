package com.test.rickandmorty.presentation.ui.character_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.test.rickandmorty.presentation.components.CharacterCard
import com.test.rickandmorty.presentation.components.SearchBar


@ExperimentalComposeUiApi
@Composable
fun CharacterScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {

    val loading = viewModel.loading.value
    val characters = viewModel.characters.value
    val charactersLastIndex = viewModel.charactersLastIndex.value
    val query = viewModel.query.value

    val rememberListState = rememberLazyListState()

    rememberListState.firstVisibleItemIndex.let {
        if (!loading && it > charactersLastIndex) {
            viewModel.onTriggerEvent(CharactersEvents.NextPageEvent)
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp),
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            SearchBar(
                query = query,
                onQueryChanged = viewModel::onChangeQuery,
                onExecuteQuery = {}
            )
        }
    ) {

        if (loading) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                state = rememberListState,
                modifier = Modifier
                    .fillMaxWidth(),
                contentPadding = it
            ) {
                itemsIndexed(items = characters) { _, item ->
                    CharacterCard(item = item) {
                        navController.navigate("CharacterDetailScreen/${item.id}")
                    }
                }
            }
        }
    }

}

