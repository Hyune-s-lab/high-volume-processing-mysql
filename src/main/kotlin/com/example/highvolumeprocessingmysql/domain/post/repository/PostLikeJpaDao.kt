package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.PostLike
import org.springframework.data.jpa.repository.JpaRepository

interface PostLikeJpaDao : JpaRepository<PostLike, Long> {
    fun countByPostId(postId: Long): Long
}
