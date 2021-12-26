package me.app

import kotlinx.coroutines.flow.toList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @GetMapping("/test")
    suspend fun test() : String {
        return Thread.currentThread().name
    }

    @Autowired
    private lateinit var repo: Repo

    @GetMapping("/test2")
    suspend fun test2() : String {
        return repo.findBy(Pageable.ofSize(10)).toList().joinToString(",") { it.toString() }

    }
}
