package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.Member

interface MemberRepository {
    fun save(member: Member): Member
    fun findById(id: Long): Member?
}
