package com.usfzy.viewmodellivedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPosts(posts: List<PostEntity>)

    @Query("SELECT * FROM posts")
    fun getAllPosts(): LiveData<List<PostEntity>>
}