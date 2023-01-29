package com.example.highvolumeprocessingmysql.domain.post.entity

import com.example.highvolumeprocessingmysql.domain.member.entity.BaseEntity
import javax.persistence.Entity

@Entity
class Timeline(
    val memberId: Long,
    val postId: Long
) : BaseEntity()
