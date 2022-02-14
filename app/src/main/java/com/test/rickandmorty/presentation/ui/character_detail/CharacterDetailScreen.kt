package com.test.rickandmorty.presentation.ui.character_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun CharacterDetailScreen(
    navController: NavController,
    characterId: String,
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        viewModel.onTriggerEvent(CharacterDetailEvents.GetCharacterEvent(characterId = characterId))
    }

    val character = viewModel.character.value
    val loading = viewModel.loading.value

    println("Character :  $character")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (loading) {
            CircularProgressIndicator(modifier = Modifier.padding(8.dp))
        } else {
            if (character == null) {
                Text(text = "There is an Error")
            } else {
                Scaffold(
                    topBar = {
                        Row(
                            modifier = Modifier
                                .fillMaxHeight(0.07f)
                                .fillMaxWidth()
                                .background(color = Color.White)
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Go Back",
                                modifier = Modifier
                                    .padding(end = 20.dp)
                                    .fillMaxHeight()
                                    .clickable { navController.navigateUp() },
                            )
                            character.name?.let {
                                Text(text = it, style = MaterialTheme.typography.h3)
                            }
                        }
                    }
                ) {
                    Column {
                        character.image?.let { characterImage ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                shape = RoundedCornerShape(10.dp),
                                elevation = 10.dp
                            ) {
                                GlideImage(
                                    imageModel = characterImage,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(400.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .shadow(5.dp)
                                .background(Color.White, shape = RoundedCornerShape(10.dp))
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                character.gender?.let {
                                    Text(
                                        text = it.toString(),
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                                character.species?.let {
                                    Text(text = it, style = MaterialTheme.typography.body1)
                                }
                                character.status?.let {
                                    Text(
                                        text = it.toString(),
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.padding(vertical = 10.dp))
                            character.origin?.let {
                                Row {
                                    Text(
                                        text = "Origin: ",
                                        style = MaterialTheme.typography.body1.copy(
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    )
                                    it.name?.let { originName ->
                                        Text(
                                            text = originName,
                                            style = MaterialTheme.typography.body1
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.padding(vertical = 10.dp))
                            character.type?.let {
                                if (it.isNotEmpty()) {
                                    Row {
                                        Text(
                                            text = "Type: ",
                                            style = MaterialTheme.typography.body1.copy(
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Text(
                                            text = it,
                                            style = MaterialTheme.typography.body1
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}