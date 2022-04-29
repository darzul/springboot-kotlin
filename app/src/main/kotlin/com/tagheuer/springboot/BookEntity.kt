package com.tagheuer.springboot

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "Book")
@Table(name = "book")
data class BookEntity(
    @Id
    @Column(name = "id")
    val id: Int,

    @Column(name = "name")
    val name: String,
)

fun BookEntity.toJson(): BookJson =
    BookJson(
        id = id,
        name = name,
    )
