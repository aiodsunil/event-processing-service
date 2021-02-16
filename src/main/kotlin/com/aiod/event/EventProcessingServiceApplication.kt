package com.aiod.event

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventProcessingServiceApplication

fun main(args: Array<String>) {
	runApplication<EventProcessingServiceApplication>(*args)
}
