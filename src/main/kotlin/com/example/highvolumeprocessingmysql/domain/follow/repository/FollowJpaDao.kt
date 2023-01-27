package com.example.highvolumeprocessingmysql.domain.follow.repository

import com.example.highvolumeprocessingmysql.domain.follow.entity.Follow
import org.springframework.data.jpa.repository.JpaRepository

interface FollowJpaDao : JpaRepository<Follow, Long> {
    fun findAllByFromMemberId(fromMemberId: Long): List<Follow>
    fun findAllByToMemberId(toMemberId: Long): List<Follow>
}
