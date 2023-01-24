package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import org.springframework.stereotype.Repository

@Repository
class MemberRepositoryImpl(private val memberJpaDao: MemberJpaDao) : MemberRepository {
    override fun save(member: Member): Member = memberJpaDao.save(member)
}
