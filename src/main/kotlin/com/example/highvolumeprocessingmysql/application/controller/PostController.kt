package com.example.highvolumeprocessingmysql.application.controller

import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCount
import com.example.highvolumeprocessingmysql.domain.post.dto.DailyPostCountRequest
import com.example.highvolumeprocessingmysql.domain.post.dto.PostCommand
import com.example.highvolumeprocessingmysql.domain.post.entity.Post
import com.example.highvolumeprocessingmysql.domain.post.service.PostReadService
import com.example.highvolumeprocessingmysql.domain.post.service.PostWriteService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/posts")
class PostController(
    private val postWriteService: PostWriteService,
    private val postReadService: PostReadService
) {
    @PostMapping
    fun create(@RequestBody command: PostCommand): Long =
        postWriteService.create(command)

    @GetMapping("/daily-post-counts")
    fun getDailyPostCounts(request: DailyPostCountRequest): List<DailyPostCount> =
        postReadService.getDailyPostCounts(request)

    @GetMapping("/members/{memberId}/page")
    fun getPagePosts(
        @PathVariable memberId: Long,
        @RequestParam page: Int,
        @RequestParam size: Int
    ): Page<Post> =
        postReadService.getPagePosts(memberId, PageRequest.of(page, size))
}
