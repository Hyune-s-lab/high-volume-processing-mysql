package com.example.highvolumeprocessingmysql.domain.follow.repository

import com.example.highvolumeprocessingmysql.domain.follow.entity.Follow
import org.springframework.stereotype.Repository

@Repository
class FollowRepositoryImpl(private val followJpaDao: FollowJpaDao) : FollowRepository {
    override fun save(follow: Follow): Follow = followJpaDao.save(follow)
    override fun findAllByFromMemberId(fromMemberId: Long): List<Follow> =
        followJpaDao.findAllByFromMemberId(fromMemberId)

    override fun findAllByToMemberId(toMemberId: Long): List<Follow> =
        followJpaDao.findAllByToMemberId(toMemberId)
}
