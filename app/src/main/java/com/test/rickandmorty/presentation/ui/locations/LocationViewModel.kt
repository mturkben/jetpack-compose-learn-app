package com.test.rickandmorty.presentation.ui.locations

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.rickandmorty.domain.model.Location
import com.test.rickandmorty.network.constant.ResponseInfo
import com.test.rickandmorty.network.model.location.LocationDtoMapper
import com.test.rickandmorty.network.response.location.RMLocationResponse
import com.test.rickandmorty.repository.RMRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel
@Inject
constructor(
    private val rmRepository: RMRepository,
    private val locationDtoMapper: LocationDtoMapper
) : ViewModel() {


    val loading: MutableState<Boolean> = mutableStateOf(true)
    val locations: MutableState<List<Location>> = mutableStateOf(listOf())
    val locationsLastIndex: MutableState<Int> = mutableStateOf(0)
    val currentPage: MutableState<Int> = mutableStateOf(1)
    val info: MutableState<ResponseInfo?> = mutableStateOf(null)


    init {
        newQuery()
    }

    fun newQuery() {
        viewModelScope.launch {
            delay(1000)
            val result = rmRepository.getAllLocations()
            responseToView(result)
        }
    }


    fun onTriggerEvent(event: LocationsEvent) {
        viewModelScope.launch {
            when (event) {
                is LocationsEvent.NewQuery -> {}
                is LocationsEvent.NextPage -> {
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
                val result = rmRepository.getLocationNewPage(pageId = currentPage.value)
                responseToView(result)
            }
        }
    }

    private fun responseToView(result: RMLocationResponse) {
        info.value = result.info
        val locationList = result.result.map { locationDtoMapper.mapToDomainModel(it) }

        if (locations.value.isEmpty()) {
            locations.value = locationList
        } else {
            val tempList = ArrayList(locations.value)
            tempList.addAll(locationList)
            locations.value = tempList
        }
        locationsLastIndex.value = locations.value.lastIndex - 15
        loading.value = false
    }
}