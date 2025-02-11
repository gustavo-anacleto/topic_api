package com.gustavo.api_kotlin.application

import com.gustavo.api_kotlin.domain.entity.Course
import com.gustavo.api_kotlin.domain.entity.Topic
import com.gustavo.api_kotlin.domain.entity.User
import com.gustavo.api_kotlin.domain.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(private val topicRepository: TopicRepository) {

    init {
        val topic1 = Topic(
            id = 1,
            title = "Duvidas Kotlin",
            message = "Variaveis Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Gustavo Anacleto",
                email = "gustavo@gmail.com"
            )
        )
        val topic2 = Topic(
            id = 2,
            title = "Duvidas Kotlin 2",
            message = "Variaveis Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Gustavo Anacleto",
                email = "gustavo@gmail.com"
            )
        )
        val topic3 = Topic(
            id = 3,
            title = "Duvidas Kotlin 3",
            message = "Variaveis Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Gustavo Anacleto",
                email = "gustavo@gmail.com"
            )
        )
    }

    fun listAll(): List<Topic>{
        return topicRepository.findAll()
    }

    fun findById(id: Long): Topic {
        return topicRepository.findById(id).orElseThrow();
    }

    fun create(topic: Topic) {
        topicRepository.save(topic)
    }
}