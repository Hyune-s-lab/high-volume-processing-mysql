package com.example.highvolumeprocessingmysql.domain.member.post

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.repository.PostRepository
import com.example.highvolumeprocessingmysql.factory.PostFixtureFactory
import io.kotest.core.spec.style.FunSpec
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import kotlin.system.measureTimeMillis

@SpringBootTest
class PostBulkInsertTest(private val postRepository: PostRepository) : FunSpec({
    test("bulkInsert") {
        val size = 10000 * 100
        var posts: List<Post>
        val elapsed = measureTimeMillis {
            posts = (1..size).asSequence()
                .map {
                    PostFixtureFactory.get(
                        4L,
                        LocalDate.of(1970, 1, 1),
                        LocalDate.of(2022, 2, 1)
                    )
                }.toList()
        }

//        val elapsed2 = measureTimeMillis {
//            postRepository.saveAll(posts)
//        }
//        postRepository.deleteAll()

        val elapsed3 = measureTimeMillis {
            postRepository.bulkInsert(
                posts.map {
                    it.createdAt = it.createdDate.atStartOfDay()
                    it
                })
        }

        println("### $size 객체 생성 시간 : $elapsed ms")
//        println("### DB jpa single insert 시간 : $elapsed2 ms")
        println("### DB jdbc bulk insert 시간 : $elapsed3 ms")
    }
})
