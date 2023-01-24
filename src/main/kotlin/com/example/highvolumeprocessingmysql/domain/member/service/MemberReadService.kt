package com.example.highvolumeprocessingmysql.domain.member.service

import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import com.example.highvolumeprocessingmysql.domain.member.dto.MemberNicknameHistoryDto
import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.example.highvolumeprocessingmysql.domain.member.entity.MemberNicknameHistory
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberNicknameHistoryRepository
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberReadService(
    private val memberRepository: MemberRepository,
    private val memberNicknameHistoryRepository: MemberNicknameHistoryRepository
) {
    fun getMember(memberId: Long) =
        memberRepository.findById(memberId)?.toDto()
            ?: throw NoSuchElementException()

    fun getNicknameHistories(memberId: Long) =
        memberNicknameHistoryRepository.findAllByMemberId(memberId).map { it.toDto() }
}

private fun Member.toDto() =
    with(this) {
        MemberDto(id!!, nickname, email, birthday)
    }

private fun MemberNicknameHistory.toDto() =
    with(this) {
        MemberNicknameHistoryDto(id!!, memberId, nickname, createdAt!!)
    }
