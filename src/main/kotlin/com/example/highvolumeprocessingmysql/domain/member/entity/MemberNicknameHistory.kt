package com.example.highvolumeprocessingmysql.domain.member.entity

import javax.persistence.Entity

@Entity
class MemberNicknameHistory(
    val memberId: Long,
    val nickname: String
) : BaseEntity()
