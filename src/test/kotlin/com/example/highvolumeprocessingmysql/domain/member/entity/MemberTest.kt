package com.example.highvolumeprocessingmysql.domain.member.entity

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class MemberTest : FunSpec({
    test("회원은 닉네임을 최대 10자이다") {
        Member(email = "pnu@fastcampus.com", nickname = "pnu", birthday = LocalDate.now())
        val exception = assertThrows<IllegalArgumentException> {
            Member(
                email = "pnu@fastcampus.com",
                nickname = "p1234567890",
                birthday = LocalDate.now()
            )
        }
        exception.message shouldBe "최대 길이를 초과했습니다."
    }
})
