package com.tagheuer.springboot

import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<BookEntity, Int>
