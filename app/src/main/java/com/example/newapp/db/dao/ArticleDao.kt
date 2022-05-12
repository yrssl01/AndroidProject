package com.example.newapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newapp.db.entity.ArticleEntity

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(articleEntity: ArticleEntity):Long

    @Query("SELECT * FROM ARTICLE")
    fun getAllOfflineArticles():LiveData<List<ArticleEntity>>

    @Delete
    suspend fun delete(articleEntity: ArticleEntity)
}