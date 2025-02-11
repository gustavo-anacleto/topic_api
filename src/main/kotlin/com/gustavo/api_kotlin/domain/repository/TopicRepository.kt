package com.gustavo.api_kotlin.domain.repository

import com.gustavo.api_kotlin.domain.entity.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<Topic, Long> {
}