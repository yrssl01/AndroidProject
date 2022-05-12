package com.example.newapp.injection

import androidx.lifecycle.LiveData
import com.example.newapp.db.AppDatabase
import com.example.newapp.db.entity.ArticleEntity
import com.example.newapp.injection.Transformer.convertArticleModelToArticleEntity
import com.example.newapp.model.Article
import javax.inject.Inject

class DBRepository @Inject constructor(val appDatabase: AppDatabase) {

    suspend fun insertArticle(article: Article): Long {
        return appDatabase.articleDao()
            .insert(convertArticleModelToArticleEntity(article))
    }

    suspend fun delete(article: Article) {
        appDatabase.articleDao().delete(convertArticleModelToArticleEntity(article))
    }

    fun getAllArticles(): LiveData<List<ArticleEntity>> {
        return appDatabase.articleDao().getAllOfflineArticles()
    }
}