package com.usfzy.viewmodellivedata.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.usfzy.viewmodellivedata.entities.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Update
    fun updateArticle(article: Article)

    @Delete
    fun deleteArticle(article: Article)

    @Query("SELECT * FROM article")
    fun loadAllArticles(): List<Article>

    @Query("SELECT * FROM article INNER JOIN joined_article_journalist ON article.id = joined_article_journalist.article_id WHERE joined_article_journalist.journalist_id = :journalistId ")
    fun loadArticlesFromAuthor(journalistId: Long): List<Article>
}