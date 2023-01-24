package com.example.highvolumeprocessingmysql.domain.member.entity

import java.time.LocalDate
import javax.persistence.Entity

@Entity
class Member(
    val nickname: String,
    val email: String,
    val birthday: LocalDate
) : BaseEntity() {
    init {
        validateNickname(nickname)
    }

    private fun validateNickname(nickname: String) {
        require(nickname.length <= NAME_MAX_LENGTH) { "최대 길이를 초과했습니다." }
    }

    companion object {
        private const val NAME_MAX_LENGTH = 10L
    }
}
