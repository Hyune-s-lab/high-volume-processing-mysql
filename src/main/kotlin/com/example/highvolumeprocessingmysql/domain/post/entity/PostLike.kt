package com.example.highvolumeprocessingmysql.domain.post.entity

import com.example.highvolumeprocessingmysql.domain.member.entity.BaseEntity
import javax.persistence.Entity

@Entity
class PostLike(
    private val memberId: Long,
    private val postId: Long,
) : BaseEntity()
