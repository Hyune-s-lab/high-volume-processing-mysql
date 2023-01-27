package com.example.highvolumeprocessingmysql.domain.post.dto

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

data class DailyPostCountRequest(
    val memberId: Long,
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    val firstDate: LocalDate,
    @field:DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    val lastDate: LocalDate
)
