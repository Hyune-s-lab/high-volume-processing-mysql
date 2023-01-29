package com.example.highvolumeprocessingmysql.domain.member.service

import com.example.highvolumeprocessingmysql.domain.member.dto.RegisterMemberCommand
import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.example.highvolumeprocessingmysql.domain.member.entity.MemberNicknameHistory
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberNicknameHistoryRepository
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MemberWriteService(
    private val memberRepository: MemberRepository,
    private val memberNicknameHistoryRepository: MemberNicknameHistoryRepository,
) {
    fun create(command: RegisterMemberCommand): Member =
        with(command) {
            val member = memberRepository.save(Member(nickname, email, birthday))
            member.saveMemberNicknameHistory()
            member
        }

    fun changeNickname(memberId: Long, nickname: String): Unit =
        memberRepository.findById(memberId)?.let {
            it.changeNickname(nickname)
            it.saveMemberNicknameHistory()
        } ?: throw NoSuchElementException()

    private fun Member.saveMemberNicknameHistory() {
        memberNicknameHistoryRepository.save(MemberNicknameHistory(memberId = this.id!!, nickname = this.nickname))
    }
}
