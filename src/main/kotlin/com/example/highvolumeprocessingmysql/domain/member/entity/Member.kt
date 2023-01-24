package com.example.highvolumeprocessingmysql.domain.member.entity

import java.time.LocalDate
import javax.persistence.Entity

@Entity
class Member(
    val nickname: String,
    val email: String,
    val birthday: LocalDate
) : BaseEntity()
