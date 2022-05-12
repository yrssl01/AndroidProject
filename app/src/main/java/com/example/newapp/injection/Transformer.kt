package com.example.newapp.injection

import com.example.newapp.db.entity.ArticleEntity
import com.example.newapp.db.entity.SourceEntity
import com.example.newapp.model.Article
import com.example.newapp.model.Source

object Transformer {

    fun convertArticleModelToArticleEntity(article: Article): ArticleEntity {
        return ArticleEntity(
            author = article.author,
            content = article.content,
            source = convertSourceModelToSourceEntity(article.source),
            description = article.description,
            publishedAt = article.publishedAt,
            url = article.url,
            urlToImage = article.urlToImage,
            title = article.title
        )
    }

    fun convertArticleEntityToArticleModel(articleEntity: ArticleEntity): Article {
        return Article(
            author = articleEntity.author,
            content = articleEntity.content,
            source = convertSourceEntityToSourceModel(articleEntity.source),
            description = articleEntity.description,
            publishedAt = articleEntity.publishedAt,
            url = articleEntity.url,
            urlToImage = articleEntity.urlToImage,
            title = articleEntity.title
        )
    }

    private fun convertSourceModelToSourceEntity(source: Source?): SourceEntity? {
        source?.let {
            return SourceEntity(source.id, source.name)
        }
        return null
    }

    private fun convertSourceEntityToSourceModel(sourceEntity: SourceEntity?): Source? {
        sourceEntity?.let {
            return Source(sourceEntity.id, sourceEntity.name)
        }
        return null
    }
}