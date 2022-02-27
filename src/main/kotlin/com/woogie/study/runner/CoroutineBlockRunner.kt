package com.woogie.study.runner

import com.woogie.study.someClient
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

fun main() {
    val log = LoggerFactory.getLogger("com.woogie.study.CoroutineRunner")

    runBlocking {
        measureTimeMillis {
            (0 until 10).map { id ->
                someClient.get().uri("/api/$id").retrieve().bodyToMono(String::class.java)
                    .doOnNext { log.info(it) }
                    .awaitSingle()
            }
        }.let { log.info("$it ms") }
    }
}

