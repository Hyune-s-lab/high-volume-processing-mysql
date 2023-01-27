package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostReadService(private val postRepository: PostRepository) {
    fun getDailyPostCounts(request: DailyPostCountRequest): List<DailyPostCount> {
        return postRepository.groupByCreatedDate(request)
    }
}
