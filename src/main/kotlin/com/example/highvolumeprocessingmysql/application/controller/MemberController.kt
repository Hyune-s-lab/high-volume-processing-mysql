package com.example.highvolumeprocessingmysql.application.controller

import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import com.example.highvolumeprocessingmysql.domain.member.dto.MemberNicknameHistoryDto
import com.example.highvolumeprocessingmysql.domain.member.dto.RegisterMemberCommand
import com.example.highvolumeprocessingmysql.domain.member.service.MemberReadService
import com.example.highvolumeprocessingmysql.domain.member.service.MemberWriteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "회원정보")
@RestController
class MemberController(
    private val memberWriteService: MemberWriteService,
    private val memberReadService: MemberReadService
) {
    @Operation(summary = "회원정보 등록")
    @PostMapping("/members")
    fun register(@RequestBody command: RegisterMemberCommand) = memberWriteService.create(command)

    @Operation(summary = "회원정보 등록")
    @GetMapping("/members/{id}")
    fun getMember(@PathVariable id: Long) = memberReadService.getMember(id)

    @Operation(summary = "회원이름 변경")
    @PostMapping("/members/{id}/name")
    fun changeNickname(@PathVariable id: Long, @RequestBody name: String): MemberDto {
        memberWriteService.changeNickname(id, name)
        return memberReadService.getMember(id)
    }

    @Operation(summary = "회원이름 변경내역 조회")
    @GetMapping("/members/{id}/name-histories")
    fun getMemberNameHistories(@PathVariable id: Long): List<MemberNicknameHistoryDto> =
        memberReadService.getNicknameHistories(id)
}
