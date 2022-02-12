package com.test.rickandmorty.presentation.ui.character_detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun CharacterDetailScreen(
    navController: NavController,
    viewModel: CharacterDetailViewModel
) {

    val characterId = viewModel.getCharacterId.value

    Surface(modifier = Modifier.fillMaxSize()) {
        Text(text = characterId.toString())
    }
}