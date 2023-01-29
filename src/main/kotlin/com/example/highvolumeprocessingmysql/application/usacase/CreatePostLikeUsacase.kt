package com.example.highvolumeprocessingmysql.application.usacase

import com.example.highvolumeprocessingmysql.domain.member.service.MemberReadService
import com.example.highvolumeprocessingmysql.domain.post.service.PostLikeWriteService
import com.example.highvolumeprocessingmysql.domain.post.service.PostReadService
import org.springframework.stereotype.Service

@Service
class CreatePostLikeUsecase(
    private val postReadService: PostReadService,
    private val memberReadService: MemberReadService,
    private val postLikeWriteService: PostLikeWriteService,
) {
    fun execute(postId: Long, memberId: Long) {
        val post = postReadService.getPost(postId)
        val member = memberReadService.getMember(memberId)
        postLikeWriteService.create(post, member)
    }
}
