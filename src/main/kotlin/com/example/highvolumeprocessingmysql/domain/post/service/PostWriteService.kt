package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.dto.PostCommand
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.repository.PostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class PostWriteService(private val postRepository: PostRepository) {
    fun create(command: PostCommand): Long {
        return postRepository.save(Post(command.memberId, command.contents)).id!!
    }

    fun likePost(postId: Long) {
        postRepository.findById(postId, true)?.let {
            it.incrementLikeCount()
            postRepository.save(it)
        } ?: throw NoSuchElementException()
    }
}
