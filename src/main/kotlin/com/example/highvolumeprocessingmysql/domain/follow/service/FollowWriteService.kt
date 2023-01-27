package com.example.highvolumeprocessingmysql.domain.follow.service

import com.example.highvolumeprocessingmysql.domain.follow.entity.Follow
import com.example.highvolumeprocessingmysql.domain.follow.repository.FollowRepository
import com.example.highvolumeprocessingmysql.domain.member.dto.MemberDto
import org.springframework.stereotype.Service

@Service
class FollowWriteService(private val followRepository: FollowRepository) {
    fun create(fromMember: MemberDto, toMember: MemberDto): Follow {
        require(fromMember.id != toMember.id) { "From, To 회원이 동일합니다." }
        return followRepository.save(Follow(fromMember.id, toMember.id))
    }
}
