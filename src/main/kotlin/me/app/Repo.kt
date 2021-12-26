package me.app

import kotlinx.coroutines.flow.Flow
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface Repo : ReactiveCrudRepository<Auth, String> {
    fun findBy(pageable: Pageable): Flow<Auth>
}