package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.PostLike

interface PostLikeRepository {
    fun save(postLike: PostLike): PostLike
    fun countByPostId(postId: Long): Long
}
