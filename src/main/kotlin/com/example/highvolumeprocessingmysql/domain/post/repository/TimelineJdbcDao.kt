package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Timeline
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class TimelineJdbcDao(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {
    fun bulkInsert(timelines: List<Timeline>) {
        val sql = String.format(
            """
                INSERT INTO `%s` (member_id, post_id, created_at)
                VALUES (:memberId, :postId, :createdAt)
                """.trimIndent(), TABLE
        )

        val params: Array<SqlParameterSource> = timelines
            .map {
                it.createdAt = LocalDateTime.now()
                it
            }
            .map { BeanPropertySqlParameterSource(it) }
            .toTypedArray()
        namedParameterJdbcTemplate.batchUpdate(sql, params)
    }

    companion object {
        const val TABLE = "timeline"
    }
}
