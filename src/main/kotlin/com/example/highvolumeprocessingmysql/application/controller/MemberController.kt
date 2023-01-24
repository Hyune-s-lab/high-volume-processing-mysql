package com.example.highvolumeprocessingmysql.application.controller

import com.example.highvolumeprocessingmysql.domain.member.dto.RegisterMemberCommand
import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.example.highvolumeprocessingmysql.domain.member.service.MemberWriteService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@Tag(name = "회원정보")
@RestController
class MemberController(
    private val memberWriteService: MemberWriteService,
) {
    @Operation(summary = "회원정보 등록")
    @PostMapping("/members")
    fun register(@RequestBody command: RegisterMemberCommand): Member {
        return memberWriteService.create(command)
    }
}
