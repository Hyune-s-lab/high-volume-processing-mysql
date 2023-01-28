package com.example.highvolumeprocessingmysql.factory

import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.navercorp.fixturemonkey.LabMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.set
import com.navercorp.fixturemonkey.kotlin.setExp
import net.jqwik.api.Arbitraries
import net.jqwik.time.api.Dates
import java.time.LocalDate

object PostFixtureFactory {
    fun get(memberId: Long, start: LocalDate, end: LocalDate): Post =
        sut.giveMeBuilder<Post>()
            .set(Post::memberId, memberId)
            .setExp(Post::contents, Arbitraries.strings().alpha().ofLength(10))
            .setExp(Post::createdDate, Dates.dates().between(start, end))
            .set(Post::likeCount, Arbitraries.integers().between(1, 10))
            .set(Post::version, 0)
            .sample()
}

private val sut = LabMonkey.labMonkeyBuilder()
    .plugin(KotlinPlugin())
    .build()
