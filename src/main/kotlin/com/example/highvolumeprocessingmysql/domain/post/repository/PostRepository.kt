package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.entity.Post

interface PostRepository {
    fun save(post: Post): Post
    fun groupByCreatedDate(request: DailyPostCountRequest): List<DailyPostCount>
}
