package com.usfzy.viewmodellivedata.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "article")
data class Article(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "time") val time: String
)

@Entity(tableName = "journalist")
data class Journalist(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "job_title") val jobTitle: String
)

@Entity(
    tableName = "joined_article_journalist",
    primaryKeys = ["article_id", "journalist_id"],
    foreignKeys = [
        ForeignKey(
            entity = Article::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("article_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Journalist::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("journalist_id"),
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class JoinedArticleJournalist(
    @ColumnInfo(name = "article_id") val articleId: Long,
    @ColumnInfo(name = "journalist_id") val journalistId: Long,
)