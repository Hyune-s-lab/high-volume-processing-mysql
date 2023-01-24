package com.example.highvolumeprocessingmysql.domain.member.dto

import java.time.LocalDateTime

data class MemberNicknameHistoryDto(
    val id: Long,
    val memberId: Long,
    val nickname: String,
    val createdAt: LocalDateTime
)
