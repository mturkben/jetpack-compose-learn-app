package com.test.rickandmorty.presentation.ui.episode_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rickandmorty.domain.model.Episode
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.episode.EpisodeDtoMapper
import com.test.rickandmorty.network.response.episode.RMEpisodeResponse
import com.test.rickandmorty.repository.RMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel
@Inject
constructor(
    private val rmRepository: RMRepository,
    private val episodeDtoMapper: EpisodeDtoMapper
) : ViewModel() {

    val episodes: MutableState<List<Episode>> = mutableStateOf(listOf())

    val episodesLastIndex: MutableState<Int> = mutableStateOf(0)

    val info: MutableState<ResponseInfo?> = mutableStateOf(null)

    val loading: MutableState<Boolean> = mutableStateOf(true)

    val currentPage: MutableState<Int> = mutableStateOf(1)

    init {
        newQuery()
    }

    fun newQuery() {
        viewModelScope.launch {
            delay(1000)
            val result = rmRepository.getAllEpisodes()
            responseToView(result)
        }
    }


    fun onTriggerEvent(event: EpisodeEvent) {
        viewModelScope.launch {
            when (event) {
                is EpisodeEvent.NewQuery -> {}
                is EpisodeEvent.NextPage -> {
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
                val result = rmRepository.getEpisodeNewPage(pageId = currentPage.value)
                responseToView(result)
            }
        }
    }

    private fun responseToView(result: RMEpisodeResponse) {
        info.value = result.info
        val episodeList = result.result.map { episodeDtoMapper.mapToDomainModel(it) }

        if (episodes.value.isEmpty()) {
            episodes.value = episodeList
        } else {
            val tempList = ArrayList(episodes.value)
            tempList.addAll(episodeList)
            episodes.value = tempList
        }
        episodesLastIndex.value = episodes.value.lastIndex - 15
        loading.value = false
    }

}