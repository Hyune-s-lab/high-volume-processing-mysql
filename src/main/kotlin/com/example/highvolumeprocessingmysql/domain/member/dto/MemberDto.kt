package com.example.highvolumeprocessingmysql.domain.member.dto

import java.time.LocalDate

data class MemberDto(val id: Long, val nickname: String, val email: String, val birthDay: LocalDate)
