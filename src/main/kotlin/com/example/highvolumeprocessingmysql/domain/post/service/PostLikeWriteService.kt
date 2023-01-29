package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.entity.PostLike
import com.example.highvolumeprocessingmysql.domain.post.repository.PostLikeRepository
import org.springframework.stereotype.Service

@Service
class PostLikeWriteService(private val postLikeRepository: PostLikeRepository) {
    fun create(post: Post, memberDto: MemberDto) {
        postLikeRepository.save(PostLike(post.id!!, memberDto.id))
    }
}
