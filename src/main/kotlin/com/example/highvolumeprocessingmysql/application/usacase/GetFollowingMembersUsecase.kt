package com.example.highvolumeprocessingmysql.application.usacase

import com.example.highvolumeprocessingmysql.domain.follow.service.FollowReadService
import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import com.example.highvolumeprocessingmysql.domain.member.service.MemberReadService
import org.springframework.stereotype.Service

@Service
class GetFollowingMembersUsecase(
    private val memberReadService: MemberReadService,
    private val followReadService: FollowReadService
) {

    fun execute(memberId: Long): List<MemberDto> {
        val followings = followReadService.getFollowings(memberId)
        val followingMemberIds = followings.map { it.toMemberId }
        return memberReadService.getMembers(followingMemberIds)
    }
}
