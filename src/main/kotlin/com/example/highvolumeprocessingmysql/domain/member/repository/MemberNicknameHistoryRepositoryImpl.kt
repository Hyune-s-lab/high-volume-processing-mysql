package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.MemberNicknameHistory
import org.springframework.stereotype.Repository

@Repository
class MemberNicknameHistoryRepositoryImpl(
    private val memberNicknameHistoryJpaDao: MemberNicknameHistoryJpaDao
) : MemberNicknameHistoryRepository {
    override fun save(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory {
        check(memberNicknameHistory.id == null) { "MemberNicknameHistory 는 갱신을 지원하지 않습니다" }
        return memberNicknameHistoryJpaDao.save(memberNicknameHistory)
    }

    override fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory> =
        memberNicknameHistoryJpaDao.findAllByMemberId(memberId)
}
