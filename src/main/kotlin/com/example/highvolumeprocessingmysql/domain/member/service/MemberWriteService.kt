package com.example.highvolumeprocessingmysql.domain.member.service

import com.example.highvolumeprocessingmysql.domain.member.dto.RegisterMemberCommand
import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import com.example.highvolumeprocessingmysql.domain.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class MemberWriteService(private val memberRepository: MemberRepository) {
    fun create(command: RegisterMemberCommand) =
        with(command) {
            memberRepository.save(Member(nickname, email, birthday))
        }
}
