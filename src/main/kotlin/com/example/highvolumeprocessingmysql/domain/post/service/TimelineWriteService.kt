package com.example.highvolumeprocessingmysql.domain.post.service

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import com.example.highvolumeprocessingmysql.domain.post.repository.TimelineRepository
import org.springframework.stereotype.Service

@Service
class TimelineWriteService(private val timelineRepository: TimelineRepository) {
    fun deliveryToTimeLine(postId: Long, toMemberIds: List<Long>) {
        val timeLines = toMemberIds.map { Timeline(it, postId) }
        timelineRepository.bulkInsert(timeLines)
    }
}
