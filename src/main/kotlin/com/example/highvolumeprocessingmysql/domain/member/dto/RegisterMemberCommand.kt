package com.example.highvolumeprocessingmysql.domain.member.dto

import java.time.LocalDate

data class RegisterMemberCommand(
    val email: String,
    val nickname: String,
    val birthday: LocalDate
)
