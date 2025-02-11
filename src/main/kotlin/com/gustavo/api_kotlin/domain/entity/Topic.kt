package com.gustavo.api_kotlin.domain.entity

import com.gustavo.api_kotlin.domain.enums.TopicStatus
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@Entity
@Table(name = "topics")
data class Topic (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "title", nullable = false)
    var title: String = "",

    @Column(name = "message", nullable = false)
    var message: String = "",

    @Column(name = "created_at", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now(),

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_user")
    var author: User? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_course", nullable = false)
    var course: Course? = null,

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING, )
    var status: TopicStatus = TopicStatus.NOT_RESPONDED,

    @OneToMany(mappedBy = "topic", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var answers: List<Answer> = emptyList()
)