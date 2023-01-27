package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(private val postJpaDao: PostJpaDao) : PostRepository {
    override fun save(post: Post) = postJpaDao.save(post)
}
