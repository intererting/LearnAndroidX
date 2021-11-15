package com.example.learnandroidx.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * @author    yiliyang
 * @date      21-4-13 上午9:19
 * @version   1.0
 * @since     1.0
 */
class FlowSearchViewModel : ViewModel() {
    private val inProgressStateFlow = MutableStateFlow(false)
    private val resultsStateFlow = MutableStateFlow(emptyList<String>())

    val showProgressBarLiveData: LiveData<Boolean> =
        inProgressStateFlow.asLiveData()

    val showRecyclerViewLiveData: LiveData<Boolean> =
        combine(resultsStateFlow, inProgressStateFlow) { results, inProgress ->
            !inProgress && results.isNotEmpty()
        }.asLiveData()

    val showEmptyStateLiveData: LiveData<Boolean> =
        combine(resultsStateFlow, inProgressStateFlow) { results, inProgress ->
            !inProgress && results.isEmpty()
        }.asLiveData()

    suspend fun search(query: String) {
        inProgressStateFlow.value = true
        resultsStateFlow.value = doSearch(query)
        inProgressStateFlow.value = false
    }

    private fun doSearch(search: String): List<String> {
        return listOf("search result with $search")
    }
}