package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.core.namedparam.SqlParameterSource
import org.springframework.stereotype.Repository

@Repository
class PostJdbcDao(private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate) {
    fun bulkInsert(posts: List<Post>) {
        val sql = String.format(
            """
                INSERT INTO `%s` (member_id, contents, created_date, created_at, like_count, version)
                VALUES (:memberId, :contents, :createdDate, :createdAt, :likeCount, :version)
                """.trimIndent(), TABLE
        )

        val params: Array<SqlParameterSource> = posts
            .map { BeanPropertySqlParameterSource(it) }
            .toTypedArray()
        namedParameterJdbcTemplate.batchUpdate(sql, params)
    }

    companion object {
        const val TABLE = "post"
    }
}
