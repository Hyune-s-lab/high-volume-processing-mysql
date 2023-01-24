package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.MemberNicknameHistory
import org.springframework.data.jpa.repository.JpaRepository

interface MemberNicknameHistoryJpaDao : JpaRepository<MemberNicknameHistory, Long> {
    fun findAllByMemberId(memberId: Long): List<MemberNicknameHistory>
}
