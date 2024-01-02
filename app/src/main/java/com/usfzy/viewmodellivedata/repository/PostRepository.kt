package com.usfzy.viewmodellivedata.repository

import androidx.lifecycle.LiveData
import com.usfzy.viewmodellivedata.api.Post
import com.usfzy.viewmodellivedata.api.PostService
import com.usfzy.viewmodellivedata.db.PostDao
import com.usfzy.viewmodellivedata.db.PostEntity
import com.usfzy.viewmodellivedata.db.PostMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.Executor

interface PostRepository {
    fun getPosts(): LiveData<List<PostEntity>>
}

class PostRepositoryImpl(
    private val postService: PostService,
    private val postDao: PostDao,
    private val postMapper: PostMapper,
    private val executer: Executor,
) : PostRepository {

    override fun getPosts(): LiveData<List<PostEntity>> {
        postService.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                response.body()?.let {
                    executer.execute {
                        postDao.insertPosts(
                            it.map { post -> postMapper.serviceToEntity(post) }
                        )
                    }
                }
            }
        })

        return postDao.getAllPosts()
    }
}