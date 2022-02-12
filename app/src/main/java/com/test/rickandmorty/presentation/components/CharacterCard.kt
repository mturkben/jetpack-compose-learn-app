package com.test.rickandmorty.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage
import com.test.rickandmorty.domain.model.Character

@Composable
fun CharacterCard(
    item: Character,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { onClick() },
        backgroundColor = MaterialTheme.colors.background,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            item.image?.let {
                GlideImage(
                    imageModel = it,
                    contentScale = ContentScale.Crop,
                    circularReveal = CircularReveal(duration = 250),
                    modifier = Modifier
                        .padding(10.dp)
                        .border(
                            BorderStroke(1.dp, MaterialTheme.colors.background),
                            shape = MaterialTheme.shapes.medium
                        )
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                item.name?.let {
                    Text(text = it, style = MaterialTheme.typography.body1)
                }
                item.status?.let {
                    Text(text = it.toString(), style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}