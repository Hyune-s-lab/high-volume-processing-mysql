package com.example.highvolumeprocessingmysql.application.usacase

import com.example.highvolumeprocessingmysql.domain.follow.service.FollowWriteService
import com.example.highvolumeprocessingmysql.domain.member.service.MemberReadService
import org.springframework.stereotype.Service

@Service
class CreateFollowMemberUsecase(
    private val memberReadService: MemberReadService,
    private val followWriteService: FollowWriteService
) {
    fun execute(fromMemberId: Long, toMemberId: Long) {
        val fromMember = memberReadService.getMember(fromMemberId)
        val toMember = memberReadService.getMember(toMemberId)
        followWriteService.create(fromMember, toMember)
    }
}
