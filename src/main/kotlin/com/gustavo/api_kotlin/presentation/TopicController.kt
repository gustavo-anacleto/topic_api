package com.gustavo.api_kotlin.presentation

import com.gustavo.api_kotlin.application.TopicService
import com.gustavo.api_kotlin.domain.entity.Course
import com.gustavo.api_kotlin.domain.entity.Topic
import com.gustavo.api_kotlin.domain.entity.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topics")
class TopicController (private val topicService: TopicService) {
    @GetMapping
    fun list(): ResponseEntity<List<Topic>>{
        val topics = topicService.listAll()

        return ResponseEntity.ok(topics)

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody topic: Topic) {
        topicService.create(topic);
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<Topic>{
        return ResponseEntity.ok(topicService.findById(id))
    }
}