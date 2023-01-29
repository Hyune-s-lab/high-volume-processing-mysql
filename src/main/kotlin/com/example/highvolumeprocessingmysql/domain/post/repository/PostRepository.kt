package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice

interface PostRepository {
    fun save(post: Post): Post
    fun saveAll(posts: List<Post>): List<Post>
    fun deleteAll()
    fun groupByCreatedDate(request: DailyPostCountRequest): List<DailyPostCount>
    fun bulkInsert(posts: List<Post>)
    fun findPageByMemberId(memberId: Long, pageRequest: PageRequest): Page<Post>
    fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Post>
    fun findSliceByMemberIdIn(memberIds: List<Long>, pageRequest: PageRequest): Slice<Post>
    fun findAllByIdIn(postIds: List<Long>): List<Post>
    fun findById(postId: Long): Post?
}
