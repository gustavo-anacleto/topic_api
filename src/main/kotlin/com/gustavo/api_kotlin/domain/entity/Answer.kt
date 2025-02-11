package com.gustavo.api_kotlin.domain.entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answers")
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "message", nullable = false)
    var message: String = "",

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    var createdBy: User? = null,

    @ManyToOne
    @JoinColumn(name = "id_topic", nullable = false)
    var topic: Topic? = null,

    @Column(name = "is_solution")
    var isSolution: Boolean = false
)
