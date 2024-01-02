package com.usfzy.viewmodellivedata.db

import com.usfzy.viewmodellivedata.api.Post

class PostMapper {

    fun serviceToEntity(post: Post): PostEntity {
        return PostEntity(
            post.id, post.userId, post.title, post.body,
        )
    }
}