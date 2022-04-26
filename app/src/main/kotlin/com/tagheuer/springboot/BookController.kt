package com.tagheuer.springboot

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {

    @GetMapping(path = ["/books"])
    fun getBooks(): ResponseEntity<Any> {
        return ResponseEntity.ok("Hello World")
    }
}
