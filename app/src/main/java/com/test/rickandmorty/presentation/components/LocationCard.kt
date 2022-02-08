package com.test.rickandmorty.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.rickandmorty.domain.model.Location


@Composable
fun LocationCard(
    item: Location,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { onClick() },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                item.name?.let {
                    Text(text = it, style = MaterialTheme.typography.body1)
                }
                item.type?.let {
                    Text(text = it, style = MaterialTheme.typography.subtitle1)
                }
            }
            item.dimension?.let {
                Text(text = it, style = MaterialTheme.typography.body2)
            }
        }
    }
}