package com.aiod.event

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Suppress("UNUSED_PARAMETER")
@Component
class EventHandler(
        private val repository: EventRepository
) {

    suspend fun events(request: ServerRequest) =ok().json().bodyAndAwait(repository.findAll())
    suspend fun counts(request: ServerRequest) =ok().json().bodyValueAndAwait(repository.count())
    suspend  fun counts2(request: ServerRequest) =ok().json().bodyValue(repository.count2()).block()
    suspend fun findOne(request: ServerRequest) =ok().json().bodyValueAndAwait(repository.findOne(request.pathVariable("id")))
    suspend fun insert(request: ServerRequest) =ok().json().bodyValueAndAwait(repository.insert(request.awaitBody()))
    suspend fun update(request: ServerRequest) =ok().json().bodyValueAndAwait(repository.update(request.awaitBody()))
    suspend fun deleteAll(request: ServerRequest) =ok().json().bodyValueAndAwait(repository.deleteAll())


}