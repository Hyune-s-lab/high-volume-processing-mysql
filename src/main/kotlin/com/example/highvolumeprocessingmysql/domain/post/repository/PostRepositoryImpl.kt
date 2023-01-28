package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(
    private val postJpaDao: PostJpaDao,
    private val postJdbcDao: PostJdbcDao
) : PostRepository {
    override fun save(post: Post) = postJpaDao.save(post)

    override fun saveAll(posts: List<Post>): List<Post> = postJpaDao.saveAll(posts)

    override fun deleteAll() = postJpaDao.deleteAllInBatch()

    override fun groupByCreatedDate(request: DailyPostCountRequest): List<DailyPostCount> =
        with(request) {
            postJpaDao.findAllByMemberIdAndCreatedDateBetween(memberId, firstDate, lastDate)
        }

    override fun bulkInsert(posts: List<Post>) = postJdbcDao.bulkInsert(posts)
}
