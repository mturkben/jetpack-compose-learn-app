package com.test.rickandmorty.presentation.ui.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rickandmorty.domain.model.Character
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.character.CharacterDtoMapper
import com.test.rickandmorty.network.response.character.RMCharacterResponse
import com.test.rickandmorty.presentation.BaseApplication
import com.test.rickandmorty.repository.RMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharactersViewModel
@Inject
constructor(
    private val rmRepository: RMRepository,
    private val application: BaseApplication,
    private val characterMapper: CharacterDtoMapper,
) : ViewModel() {


    val query: MutableState<String> = mutableStateOf("")

    val loading: MutableState<Boolean> = mutableStateOf(true)

    val characters: MutableState<List<Character>> = mutableStateOf(listOf())

    val charactersLastIndex: MutableState<Int> = mutableStateOf(0)

    val info: MutableState<ResponseInfo?> = mutableStateOf(null)

    val currentPage: MutableState<Int> = mutableStateOf(1)

    init {
        newQuery()
    }

    fun onTriggerEvent(events: CharactersEvents) {
        viewModelScope.launch {
            when (events) {
                is CharactersEvents.NewSearchEvent -> {
                    newQuery()
                }
                is CharactersEvents.NextPageEvent -> {
                    currentPage.value = currentPage.value + 1
                    nextPage()
                }
                else -> {}
            }
        }
    }

    private fun nextPage() {
        viewModelScope.launch {
            if (info.value?.pages!! >= currentPage.value) {
                val result = rmRepository.getCharactersNewPage(pageId = currentPage.value)
                responseToView(result)
            }
        }
    }

    private fun newQuery() {
        viewModelScope.launch {
            delay(1000)
            val result = rmRepository.getAllCharacters()
            responseToView(result)
        }
    }

    private fun responseToView(result: RMCharacterResponse) {
        info.value = result.info
        val newCharacters = result.results.map { characterMapper.mapToDomainModel(it) }

        if (characters.value.isEmpty()) {
            characters.value = newCharacters
        } else {
            val tempList = ArrayList(characters.value)
            tempList.addAll(newCharacters)
            characters.value = tempList
        }
        charactersLastIndex.value = characters.value.lastIndex - 10
        loading.value = false
    }

    fun onChangeQuery(newQuery: String) {
        query.value = newQuery
    }

}