package com.aiod.event

import com.aiod.event.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.springframework.data.mongodb.core.*
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository
import kotlinx.coroutines.async

@Repository
class EventRepository(
        private val mongo: ReactiveFluentMongoOperations
) {
     suspend fun count():Long= coroutineScope{

         mongo.query<Event>().awaitCount()
//         println("${Thread.currentThread()}")
//         val result = async(Dispatchers.IO){mongo.query<Event>().awaitCount()}
//         result.await()
     }

      fun count2(): Long {
          println("${Thread.currentThread()}")
         return  mongo.query<Event>().count().block()!!
      }


          fun findAll() = mongo.query<Event>().flow()

          suspend fun findOne(id: String) = mongo.query<Event>().matching(query(where("id").isEqualTo(id))).awaitOne()

          suspend fun deleteAll() {
              mongo.remove<Event>().allAndAwait()
          }

          suspend fun update(event: Event) = mongo.update<Event>().replaceWith(event).asType<Event>().findReplaceAndAwait()

          suspend fun insert(event: Event) = mongo.insert<Event>().oneAndAwait(event)
      }


