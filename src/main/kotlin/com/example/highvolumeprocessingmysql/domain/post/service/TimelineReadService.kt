package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import com.example.highvolumeprocessingmysql.domain.post.repository.TimelineRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Service

@Service
class TimelineReadService(private val timelineRepository: TimelineRepository) {
    fun getTimelines(memberId: Long, pageRequest: PageRequest): Slice<Timeline> {
        return timelineRepository.findSliceByMemberId(memberId, pageRequest)
    }
}
