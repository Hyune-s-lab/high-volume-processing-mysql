package com.example.highvolumeprocessingmysql.domain.member.entity

import com.example.highvolumeprocessingmysql.factory.MemberFixtureFactory
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberTest : FunSpec({
    test("회원은 닉네임을 변경할 수 있다") {
        val member = MemberFixtureFactory.create()
        val expected = "cat"
        member.changeNickname(expected)
        expected shouldBe member.nickname
    }

    test("회원 닉네임의 길이는 10자를 초과할 수 없다") {
        val member = MemberFixtureFactory.create()
        val overMaxLengthName = "superChairman"
        val exception = assertThrows<IllegalArgumentException> { member.changeNickname(overMaxLengthName) }
        exception.message shouldBe "최대 길이를 초과했습니다."
    }
})
