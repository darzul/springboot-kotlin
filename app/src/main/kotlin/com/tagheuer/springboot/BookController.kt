package com.tagheuer.springboot

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
class BookController(
    private val service: BookService,
) {

    @GetMapping(path = ["/books"])
    fun getBooks(): ResponseEntity<Any> {
        return ResponseEntity.ok(service.getAllBooks())
    }

    @PostMapping(path = ["/books"])
    fun createBook(@RequestBody body: CreateBookJson): ResponseEntity<Any> {
        val book = service.createBook(body)
        return ResponseEntity.created(URI.create("/books/${book.id}")).build()
    }

    @DeleteMapping(path = ["/books/{id}"])
    fun createBook(@PathVariable id: Int): ResponseEntity<Any> {
        service.deleteBook(id)
        return ResponseEntity.accepted().build()
    }
}

data class CreateBookJson(
    @JsonProperty("name")
    val name: String?,
)
