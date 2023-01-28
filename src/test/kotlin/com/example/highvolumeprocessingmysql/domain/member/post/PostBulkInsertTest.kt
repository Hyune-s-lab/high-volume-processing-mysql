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
        var posts: List<Post>
        val elapsed = measureTimeMillis {
            posts = (0..10000).asSequence()
                .map {
                    PostFixtureFactory.get(
                        4L,
                        LocalDate.of(1970, 1, 1),
                        LocalDate.of(2022, 2, 1)
                    )
                }.toList()
        }
        println("### 객체 생성 시간 : $elapsed")

        postRepository.deleteAll()

        val elapsed2 = measureTimeMillis {
            postRepository.saveAll(posts)
        }
        println("### DB 인서트 시간 : $elapsed2")
    }
})
