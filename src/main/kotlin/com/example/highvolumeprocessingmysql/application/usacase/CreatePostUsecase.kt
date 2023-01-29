package com.example.highvolumeprocessingmysql.application.usacase

import com.example.highvolumeprocessingmysql.domain.follow.service.FollowReadService
import com.example.highvolumeprocessingmysql.domain.post.dto.PostCommand
import com.example.highvolumeprocessingmysql.domain.post.service.PostWriteService
import com.example.highvolumeprocessingmysql.domain.post.service.TimelineWriteService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreatePostUsecase(
    private val postWriteService: PostWriteService,
    private val followReadService: FollowReadService,
    private val timelineWriteService: TimelineWriteService,
) {
    @Transactional
    fun execute(command: PostCommand): Long {
        val postId = postWriteService.create(command)
        val followerMemberIds = followReadService.getFollowers(command.memberId)
            .map { it.fromMemberId }
        timelineWriteService.deliveryToTimeLine(postId, followerMemberIds)
        return postId
    }
}
