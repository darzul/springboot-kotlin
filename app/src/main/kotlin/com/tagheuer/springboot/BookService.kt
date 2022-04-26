package com.tagheuer.springboot

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class BookService {

    val books = mutableListOf(
        Book(
            id = 1,
            name = "Harry Potter",
        ),
        Book(
            id = 2,
            name = "Test",
        ),
    )

    fun getAllBooks(): List<BookJson> {
        return books.map { it.toJson() }
    }

    fun createBook(request: CreateBookJson): Book {
        if (request.name.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        val book = Book(
            id = Random.nextInt(),
            name = request.name,
        )

        books.add(book.toDomain())

        return book
    }

    fun deleteBook(id: Int) {
        books.removeIf { it.id == id }
    }
}
