package com.example.highvolumeprocessingmysql.application.controller

import com.example.highvolumeprocessingmysql.application.usacase.CreateFollowMemberUsecase
import com.example.highvolumeprocessingmysql.application.usacase.GetFollowingMembersUsecase
import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "팔로우 정보")
@RestController
@RequestMapping("/follow")
class FollowController(
    private val createFollowMemberUsecase: CreateFollowMemberUsecase,
    private val getFollowingMembersUsecase: GetFollowingMembersUsecase
) {
    @Operation(summary = "팔로우 등록")
    @PostMapping("/{fromId}/{toId}")
    fun register(@PathVariable fromId: Long, @PathVariable toId: Long): List<MemberDto> {
        createFollowMemberUsecase.execute(fromId, toId)
        return getFollowingMembersUsecase.execute(fromId)
    }

    @Operation(summary = "팔로워 조회")
    @GetMapping("/members/{fromId}")
    fun getFollowers(@PathVariable fromId: Long): List<MemberDto> {
        return getFollowingMembersUsecase.execute(fromId)
    }
}
