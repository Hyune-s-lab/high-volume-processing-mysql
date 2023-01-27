package com.example.highvolumeprocessingmysql.domain.follow.repository

import com.example.highvolumeprocessingmysql.domain.follow.entity.Follow

interface FollowRepository {
    fun save(follow: Follow): Follow
    fun findAllByFromMemberId(fromMemberId: Long): List<Follow>
    fun findAllByToMemberId(toMemberId: Long): List<Follow>
}
