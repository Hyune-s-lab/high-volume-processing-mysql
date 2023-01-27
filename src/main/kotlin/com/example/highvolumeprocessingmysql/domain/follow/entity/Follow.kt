package com.example.highvolumeprocessingmysql.domain.follow.entity

import com.example.highvolumeprocessingmysql.domain.member.entity.BaseEntity
import javax.persistence.Entity

@Entity
class Follow constructor(
    val fromMemberId: Long,
    val toMemberId: Long,
) : BaseEntity()
