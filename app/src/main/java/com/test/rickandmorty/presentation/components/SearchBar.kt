package com.test.rickandmorty.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalTextInputService
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@ExperimentalComposeUiApi
@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteQuery: () -> Unit,
) {
    val isTextFieldFocused = remember { mutableStateOf(false) }
    val inputService = LocalTextInputService.current
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(10.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = 8.dp,
        color = MaterialTheme.colors.secondary,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.CenterEnd
        ) {
            TextField(
                value = query,
                onValueChange = { onQueryChanged(it) },
                modifier = Modifier
                    .fillMaxSize()
                    .onFocusChanged { isTextFieldFocused.value = it.isFocused },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = {
                    onExecuteQuery()
                    inputService?.hideSoftwareKeyboard()
                    isTextFieldFocused.value = false
                    focusManager.clearFocus()
                }),
                label = {
                    Text(text = "Search...", style = MaterialTheme.typography.body1)
                }
            )
            Icon(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clickable {
                        onExecuteQuery()
                        inputService?.hideSoftwareKeyboard()
                        isTextFieldFocused.value = false
                        focusManager.clearFocus()
                    }
                    .padding(10.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = if (isTextFieldFocused.value) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
            )
        }
    }
}