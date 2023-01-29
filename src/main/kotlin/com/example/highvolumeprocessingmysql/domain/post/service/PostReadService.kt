package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.dto.PostDto
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.repository.PostLikeRepository
import com.example.highvolumeprocessingmysql.domain.post.repository.PostRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class PostReadService(
    private val postRepository: PostRepository,
    private val postLikeRepository: PostLikeRepository,
) {
    fun getDailyPostCounts(request: DailyPostCountRequest): List<DailyPostCount> =
        postRepository.groupByCreatedDate(request)

    fun getPagePosts(memberId: Long, pageRequest: PageRequest): Page<PostDto> =
        postRepository.findPageByMemberId(memberId, pageRequest)
            .map { PostDto(it, postLikeRepository.countByPostId(it.id!!)) }

    fun getSlicePosts(memberId: Long, pageRequest: PageRequest): Slice<Post> =
        postRepository.findSliceByMemberId(memberId, pageRequest)

    fun getSlicePosts(memberIds: List<Long>, pageRequest: PageRequest): Slice<Post> =
        postRepository.findSliceByMemberIdIn(memberIds, pageRequest)

    fun getPosts(postIds: List<Long>): List<Post> =
        postRepository.findAllByIdIn(postIds)

    fun getPost(postId: Long): Post =
        postRepository.findById(postId, false) ?: throw NoSuchElementException()
}
