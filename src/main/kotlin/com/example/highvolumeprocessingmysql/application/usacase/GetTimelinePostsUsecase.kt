package com.example.highvolumeprocessingmysql.application.usacase

import com.example.highvolumeprocessingmysql.domain.follow.service.FollowReadService
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.service.PostReadService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class GetTimelinePostsUsecase(
    private val followReadService: FollowReadService,
    private val postReadService: PostReadService
) {
    fun execute(memberId: Long, pageRequest: PageRequest): Slice<Post> {
        val follows = followReadService.getFollowings(memberId)
        val followerMemberIds = follows.map { it.toMemberId }
        return postReadService.getSlicePosts(followerMemberIds, pageRequest)
    }

//    fun executeByTimeline(memberId: Long, pageRequest: PageRequest): Slice<Post> {
//        val pagedTimelines: Unit = timelineReadService.getTimelines(memberId, cursorRequest)
//        val postIds: Unit = pagedTimelines.body().stream().map(Timeline::getPostId).toList()
//        val posts: Unit = postReadService.getPostDtos(postIds)
//        return PageCursor(pagedTimelines.nextCursorRequest(), posts)
//    }
}
