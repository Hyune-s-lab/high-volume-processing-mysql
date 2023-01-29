package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Repository

@Repository
class TimelineRepositoryImpl(
    private val timelineJdbcDao: TimelineJdbcDao,
    private val timelineJpaDao: TimelineJpaDao
) : TimelineRepository {
    override fun save(timeline: Timeline): Timeline = timelineJpaDao.save(timeline)
    override fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Timeline> =
        timelineJpaDao.findSliceByMemberId(memberId, pageRequest)

    override fun bulkInsert(timelines: List<Timeline>): Unit = timelineJdbcDao.bulkInsert(timelines)
}
