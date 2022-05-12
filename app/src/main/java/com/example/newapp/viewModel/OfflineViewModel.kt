package com.example.newapp.viewModel

import androidx.lifecycle.*
import com.example.newapp.injection.DBRepository
import com.example.newapp.injection.Transformer
import com.example.newapp.model.Article
import com.example.newapp.utils.DataHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfflineViewModel @Inject constructor(private val dbRepository: DBRepository) : ViewModel() {

    var article = Transformations.map(dbRepository.getAllArticles()) { list ->

        val temp = list.map {
            Transformer.convertArticleEntityToArticleModel(it)
        }
        if (temp.isNullOrEmpty()) {
            DataHandler.ERROR(null, "No data in list")
        } else {
            DataHandler.SUCCESS(temp)
        }
    }

    fun insertArticle(article: Article) {
        viewModelScope.launch {
            dbRepository.insertArticle(article)
        }
    }

    fun deleteArticle(article: Article) {
        viewModelScope.launch {
            dbRepository.delete(article)
        }
    }
}