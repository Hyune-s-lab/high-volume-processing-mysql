package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostJpaDao : JpaRepository<Post, Long>
