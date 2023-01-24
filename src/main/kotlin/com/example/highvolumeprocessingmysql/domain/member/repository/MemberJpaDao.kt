package com.example.highvolumeprocessingmysql.domain.member.repository

import com.example.highvolumeprocessingmysql.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaDao : JpaRepository<Member, Long>
