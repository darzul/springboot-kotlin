package com.tagheuer.springboot

import com.fasterxml.jackson.annotation.JsonProperty

class BookJson(
    @JsonProperty("id")
    val id: Int,

    @JsonProperty("name")
    val name: String,
)

fun Book.toJson(): BookJson = BookJson(id = id, name = name)

fun Book.toDomain(): Book = Book(id = id, name = name)
