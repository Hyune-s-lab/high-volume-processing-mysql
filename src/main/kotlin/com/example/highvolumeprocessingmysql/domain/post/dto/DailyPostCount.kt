package com.example.highvolumeprocessingmysql.domain.post.dto

import java.time.LocalDate

data class DailyPostCount(val memberId: Long, val date: LocalDate, val postCount: Long)
