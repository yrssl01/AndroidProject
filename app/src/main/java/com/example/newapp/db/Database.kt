package com.example.newapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newapp.db.dao.ArticleDao
import com.example.newapp.db.entity.ArticleEntity

@Database(
    version = 1,
    entities = [ArticleEntity::class],
)
@TypeConverters(Converter::class)
abstract class AppDatabase :RoomDatabase(){

    abstract fun articleDao(): ArticleDao
}