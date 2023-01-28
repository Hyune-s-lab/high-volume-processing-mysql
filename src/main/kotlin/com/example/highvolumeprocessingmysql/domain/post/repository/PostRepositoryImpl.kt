package com.example.highvolumeprocessingmysql.domain.post.repository

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Slice
import org.springframework.stereotype.Repository

@Repository
class PostRepositoryImpl(
    private val postJpaDao: PostJpaDao,
    private val postJdbcDao: PostJdbcDao
) : PostRepository {
    override fun save(post: Post): Post = postJpaDao.save(post)

    override fun saveAll(posts: List<Post>): List<Post> = postJpaDao.saveAll(posts)

    override fun deleteAll(): Unit = postJpaDao.deleteAllInBatch()

    override fun groupByCreatedDate(request: DailyPostCountRequest): List<DailyPostCount> =
        with(request) {
            postJpaDao.findAllByMemberIdAndCreatedDateBetween(memberId, firstDate, lastDate)
        }

    override fun bulkInsert(posts: List<Post>): Unit = postJdbcDao.bulkInsert(posts)

    override fun findPageByMemberId(memberId: Long, pageRequest: PageRequest): Page<Post> =
        postJpaDao.findPageByMemberId(memberId, pageRequest)

    override fun findSliceByMemberId(memberId: Long, pageRequest: PageRequest): Slice<Post> =
        postJpaDao.findSliceByMemberId(memberId, pageRequest)
}
