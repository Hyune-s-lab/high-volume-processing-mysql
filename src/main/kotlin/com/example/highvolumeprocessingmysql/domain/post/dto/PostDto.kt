package com.example.highvolumeprocessingmysql.domain.post.dto

import java.time.LocalDateTime

data class PostDto(
    val id: Long,
    val memberId: Long,
    val contents: String,
    val createdAt: LocalDateTime,
    val likeCount: Long
)
