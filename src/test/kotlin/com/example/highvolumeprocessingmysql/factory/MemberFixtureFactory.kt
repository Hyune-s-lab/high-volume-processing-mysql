package com.example.highvolumeprocessingmysql.factory

import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.navercorp.fixturemonkey.LabMonkey
import com.navercorp.fixturemonkey.kotlin.KotlinPlugin
import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import net.jqwik.api.Arbitraries
import java.time.LocalDate

object MemberFixtureFactory {
    fun create(): Member = sut.giveMeBuilder<Member>()
        .setExp(Member::nickname, Arbitraries.strings().alpha().ofLength(10))
        .setExp(Member::email, Arbitraries.strings().alpha().ofLength(10))
        .setExp(Member::birthday, sut.giveMeOne(LocalDate::class.java))
        .sample()
}

private val sut = LabMonkey.labMonkeyBuilder()
    .plugin(KotlinPlugin())
    .build()
