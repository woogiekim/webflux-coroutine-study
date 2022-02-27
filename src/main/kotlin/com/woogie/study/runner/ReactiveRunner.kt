package com.woogie.study.runner

import com.woogie.study.someClient
import org.slf4j.LoggerFactory
import reactor.core.publisher.Mono
import kotlin.system.measureTimeMillis

fun main() {
    val log = LoggerFactory.getLogger("com.woogie.study.ReactiveRunner")

    measureTimeMillis {
        val bodies: List<Mono<String>> = (0 until 100).map { id ->
            someClient.get().uri("/api/$id").retrieve().bodyToMono(String::class.java)
                .doOnNext { log.info(it) }
        }

        // Mono.`when`(bodies).block()
        val result = Mono.zip(bodies) { it.map { any -> any as String } }.block()!!
        println("result size: ${result.size}")
    }.let { log.info("$it ms") }
}