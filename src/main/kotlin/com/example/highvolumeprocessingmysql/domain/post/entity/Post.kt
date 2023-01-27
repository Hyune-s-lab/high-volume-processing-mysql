package com.example.highvolumeprocessingmysql.domain.post.entity

import com.example.highvolumeprocessingmysql.domain.member.entity.BaseEntity
import java.time.LocalDate
import javax.persistence.Entity

@Entity
class Post constructor(
    val memberId: Long,
    val contents: String,
    val createdDate: LocalDate = LocalDate.now(),
    val likeCount: Long = 0,
    val version: Long = 0
) : BaseEntity()
