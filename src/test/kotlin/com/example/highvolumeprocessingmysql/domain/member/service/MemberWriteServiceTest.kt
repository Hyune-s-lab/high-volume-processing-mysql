package com.example.highvolumeprocessingmysql.domain.member.service

import com.example.highvolumeprocessingmysql.domain.member.dto.RegisterMemberCommand
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberRepository
import io.kotest.core.spec.Spec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate

@SpringBootTest
class MemberWriteServiceTest(
    private val memberWriteService: MemberWriteService,
    private val memberRepository: MemberRepository
) : FunSpec({
    test("회원정보 등록 테스트") {
        val command = RegisterMemberCommand(
            "pnu@fastcampus.com",
            "pnu",
            LocalDate.now()
        )

        val member = memberWriteService.create(command)

        member.id shouldNotBe null
        member.nickname shouldBe command.nickname
        member.email shouldBe command.email
    }
}) {
    override suspend fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        memberRepository.deleteAll()
    }
}
