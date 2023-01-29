package com.example.highvolumeprocessingmysql.domain.post.dto

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import java.time.LocalDateTime

data class PostDto(
    val id: Long,
    val memberId: Long,
    val contents: String,
    val createdAt: LocalDateTime,
    val likeCount: Long,
) {
    constructor(post: Post) : this(post.id!!, post.memberId, post.contents, post.createdAt!!, post.likeCount)
}
