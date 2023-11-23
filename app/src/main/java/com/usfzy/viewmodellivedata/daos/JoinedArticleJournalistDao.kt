package com.usfzy.viewmodellivedata.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.usfzy.viewmodellivedata.entities.JoinedArticleJournalist

interface JoinedArticleJournalistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticleJournalist(articleJournalist: JoinedArticleJournalist)

    @Delete
    fun deleteArticleJournalist(articleJournalist: JoinedArticleJournalist)
}