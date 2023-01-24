package com.example.highvolumeprocessingmysql.domain.member.service

import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberReadService(private val memberRepository: MemberRepository) {
    fun getMember(memberId: Long): MemberDto =
        memberRepository.findById(memberId)?.toDto()
            ?: throw NoSuchElementException()
}

private fun Member.toDto() =
    with(this) {
        MemberDto(id!!, nickname, email, birthday)
    }
