package ru.netology.fmhandroid.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.netology.fmhandroid.dto.News
import ru.netology.fmhandroid.dto.NewsWithCategory
import ru.netology.fmhandroid.repository.newsRepository.NewsRepository
import javax.inject.Inject


@HiltViewModel
class NewsControlPanelViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {

    private val clearFilter = Filter(
        newsCategoryId = null,
        dateStart = null,
        dateEnd = null
    )
    private val sortDirection = MutableStateFlow(NewsViewModel.SortDirection.ASC)
    private val filterFlow = MutableStateFlow(
        clearFilter
    )

    val loadNewsExceptionEvent = MutableSharedFlow<Unit>()
    val newsItemCreatedEvent = MutableSharedFlow<Unit>()
    val saveNewsItemExceptionEvent = MutableSharedFlow<Unit>()
    val editNewsItemSavedEvent = MutableSharedFlow<Unit>()
    val editNewsItemExceptionEvent = MutableSharedFlow<Unit>()
    val removeNewsItemExceptionEvent = MutableSharedFlow<Unit>()

    val data: Flow<List<NewsWithCategory>> = filterFlow.flatMapMerge { filter ->
        newsRepository.getAllNews(
            viewModelScope,
            newsCategoryId = filter.newsCategoryId,
            dateStart = filter.dateStart,
            dateEnd = filter.dateEnd
        ).combine(sortDirection) { news, sortDirection ->
            when (sortDirection) {
                NewsViewModel.SortDirection.ASC -> news
                NewsViewModel.SortDirection.DESC -> news.reversed()
            }
        }
    }.onStart { internalOnRefresh() }

    fun onRefresh() {
        viewModelScope.launch {
            try {
                newsRepository.refreshNews()
            } catch (e: Exception) {
                e.printStackTrace()
                loadNewsExceptionEvent.emit(Unit)
            }
        }
    }

    private suspend fun internalOnRefresh() {
        try {
            newsRepository.refreshNews()
        } catch (e: Exception) {
            e.printStackTrace()
            loadNewsExceptionEvent.emit(Unit)
        }
    }

    fun onSortDirectionButtonClicked() {
        sortDirection.value = sortDirection.value.reverse()
    }

    fun onFilterNewsClicked(
        newsCategoryId: Int?,
        dateStart: Long?,
        dateEnd: Long?
    ) {
        filterFlow.value = Filter(
            newsCategoryId,
            dateStart,
            dateEnd
        )
    }

    fun save(newsItem: News) {
        viewModelScope.launch {
            try {
                newsRepository.createNews(newsItem)
                newsItemCreatedEvent.emit(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                saveNewsItemExceptionEvent.emit(Unit)
            }
        }
    }

    fun edit(newsItem: News) {
        viewModelScope.launch {
            try {
                newsRepository.modificationOfExistingNews(newsItem)
                editNewsItemSavedEvent.emit(Unit)
            } catch (e: Exception) {
                e.printStackTrace()
                editNewsItemExceptionEvent.emit(Unit)
            }
        }
    }

    fun remove(id: Int) {
        viewModelScope.launch {
            try {
                newsRepository.removeNewsItemById(id)
            } catch (e: Exception) {
                e.printStackTrace()
                removeNewsItemExceptionEvent.emit(Unit)
            }
        }
    }

    fun getAllNewsCategories() = newsRepository.getAllNewsCategories()

    private class Filter(
        val newsCategoryId: Int?,
        val dateStart: Long?,
        val dateEnd: Long?
    )

    fun onCard(newsItem: News) {
        viewModelScope.launch {
            if (newsItem.isOpen) {
                newsRepository.changeIsOpen(newsItem.copy(isOpen = false))
            } else {
                newsRepository.changeIsOpen(newsItem.copy(isOpen = true))
            }
        }
    }
}
