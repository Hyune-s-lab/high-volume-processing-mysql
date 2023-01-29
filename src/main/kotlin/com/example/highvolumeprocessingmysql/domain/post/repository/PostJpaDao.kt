package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface PostJpaDao : JpaRepository<Post, Long> {
    @Query(
        """
        SELECT new com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount(p.memberId, p.createdDate, count(p.id)) 
                FROM Post p
                WHERE p.memberId = :memberId and p.createdDate between :firstDate and :lastDate
                GROUP BY p.memberId, p.createdDate
        """
    )
    fun findAllByMemberIdAndCreatedDateBetween(
        memberId: Long,
        firstDate: LocalDate,
        lastDate: LocalDate
    ): List<DailyPostCount>

    fun findPageByMemberId(memberId: Long, pageRequest: PageRequest): Page<Post>
    fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Post>
    fun findSliceByMemberIdIn(memberIds: List<Long>, pageRequest: PageRequest): Slice<Post>
    fun findAllByIdIn(postIds: List<Long>): List<Post>
}
