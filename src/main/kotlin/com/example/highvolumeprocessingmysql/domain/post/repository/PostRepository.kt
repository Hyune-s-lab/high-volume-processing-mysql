package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Post

interface PostRepository {
    fun save(post: Post): Post
}
