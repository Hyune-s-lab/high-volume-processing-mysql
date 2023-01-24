package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.MemberNicknameHistory

interface MemberNicknameHistoryRepository {
    fun save(memberNicknameHistory: MemberNicknameHistory): MemberNicknameHistory
    fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory>
}
