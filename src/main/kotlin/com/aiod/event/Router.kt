package com.aiod.event

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class Routing {
    @Bean
    fun routes(eventHandler: EventHandler) = coRouter {

        GET("/api/events", eventHandler::events)
        GET("/api/counts") { eventHandler.counts(it) }
        GET("/api/counts_2") { request -> eventHandler.counts2(request)!! }
        GET("/api/findOne/{id}", eventHandler::findOne)
        POST("/api/insert", eventHandler::insert)
        PUT("/api/update", eventHandler::update)
        DELETE("/api/deleteAll", eventHandler::deleteAll)

    }
}