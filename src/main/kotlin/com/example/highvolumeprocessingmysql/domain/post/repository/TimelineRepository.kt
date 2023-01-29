package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice

interface TimelineRepository {
    fun save(timeline: Timeline): Timeline
    fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Timeline>
    fun bulkInsert(timelines: List<Timeline>)
}
