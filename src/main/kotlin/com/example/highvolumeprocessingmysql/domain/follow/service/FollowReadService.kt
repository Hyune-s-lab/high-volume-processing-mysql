package com.example.highvolumeprocessingmysql.domain.follow.service

import com.example.highvolumeprocessingmysql.domain.follow.entity.Follow
import com.example.highvolumeprocessingmysql.domain.follow.repository.FollowRepository
import org.springframework.stereotype.Service

@Service
class FollowReadService(private val followRepository: FollowRepository) {
    fun getFollowings(memberId: Long): List<Follow> = followRepository.findAllByFromMemberId(memberId)
}
