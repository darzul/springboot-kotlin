package com.tagheuer.springboot

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class BookService(
    private val repository: BookRepository,
) {

    fun getAllBooks(): List<BookJson> {
        return repository.findAll().map { it.toJson() }
    }

    fun createBook(request: CreateBookJson): BookJson {
        if (request.name.isNullOrBlank()) {
            throw IllegalArgumentException()
        }

        val book = BookEntity(
            id = Random.nextInt(),
            name = request.name,
        )

        repository.save(book)

        return book.toJson()
    }

    fun deleteBook(id: Int) {
        repository.deleteById(id)
    }
}
