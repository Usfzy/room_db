package com.usfzy.viewmodellivedata.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usfzy.viewmodellivedata.daos.ArticleDao
import com.usfzy.viewmodellivedata.daos.JoinedArticleJournalistDao
import com.usfzy.viewmodellivedata.daos.JournalistDao
import com.usfzy.viewmodellivedata.entities.Article
import com.usfzy.viewmodellivedata.entities.JoinedArticleJournalist
import com.usfzy.viewmodellivedata.entities.Journalist

@Database(
    entities = [Article::class, Journalist::class, JoinedArticleJournalist::class],
    version = 1,
)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun articleDao(): ArticleDao

    abstract fun journalistDao(): JournalistDao

    abstract fun joinedArticleJournalistDao(): JoinedArticleJournalistDao
}