package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.entity.PostLike
import org.springframework.stereotype.Repository

@Repository
class PostLikeRepositoryImpl(
    private val postLikeJpaDao: PostLikeJpaDao,
) : PostLikeRepository {
    override fun save(postLike: PostLike): PostLike =
        postLikeJpaDao.save(postLike)
}
