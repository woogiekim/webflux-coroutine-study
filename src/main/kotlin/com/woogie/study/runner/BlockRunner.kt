package com.woogie.study

import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

fun main() {
    val log = LoggerFactory.getLogger("com.woogie.study.BlockRunner")

    measureTimeMillis {
        (1 until 10).forEach { id ->
            someClient.get().uri("/api/$id").retrieve().bodyToMono(String::class.java)
                .doOnNext { log.info(it) }
                .block()
        }
    }.let { log.info("$it ms") }
}