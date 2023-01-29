package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository

interface TimelineJpaDao : JpaRepository<Timeline, Long> {
    fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Timeline>
}
