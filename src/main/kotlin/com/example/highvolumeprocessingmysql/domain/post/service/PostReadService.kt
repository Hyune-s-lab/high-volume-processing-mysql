package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.repository.PostRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class PostReadService(private val postRepository: PostRepository) {
    fun getDailyPostCounts(request: DailyPostCountRequest): List<DailyPostCount> =
        postRepository.groupByCreatedDate(request)

    fun getPagePosts(memberId: Long, pageRequest: PageRequest): Page<Post> =
        postRepository.findPageByMemberId(memberId, pageRequest)

    fun getSlicePosts(memberId: Long, pageRequest: PageRequest): Slice<Post> =
        postRepository.findSliceByMemberId(memberId, pageRequest)
}
