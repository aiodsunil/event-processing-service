package com.aiod.event

import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Event(var  id: String?=null, val name: String,
                 val type: String, val status: String,
                 val date: LocalDateTime= LocalDateTime.now())