package com.woogie.study

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit
import kotlin.random.Random

@RestController
class SomeExternalApi {

    private val latencies: List<Long> = listOf(400L, 900L, 600L, 300L, 400L, 600L, 200L, 100L, 600L, 700L, 800L, 0L, 0L, 500L, 400L, 400L, 200L, 500L, 300L, 600L, 800L, 500L, 100L, 300L, 0L, 500L, 100L, 0L, 700L, 900L, 800L, 300L, 700L, 700L, 500L, 900L, 200L, 300L, 400L, 400L, 700L, 800L, 900L, 900L, 700L, 300L, 0L, 300L, 300L, 100L, 400L, 100L, 200L, 200L, 700L, 900L, 800L, 100L, 100L, 0L, 700L, 100L, 900L, 100L, 600L, 400L, 300L, 700L, 800L, 100L, 600L, 700L, 0L, 800L, 200L, 600L, 800L, 300L, 400L, 800L, 400L, 0L, 900L, 400L, 200L, 600L, 400L, 400L, 0L, 900L, 900L, 700L, 500L, 900L, 100L, 100L, 0L, 800L, 400L, 200L)

    @GetMapping("/api/{id}")
    fun api(@PathVariable id: Int): String {

        TimeUnit.MILLISECONDS.sleep(latencies[id])

        return "id: $id, latency: ${latencies[id]}"
    }
}

fun main() {
    (0 until 100)
        .map { Random.nextInt(0, 10) * 100 }
        .joinToString("L, ")
        .also { println(it) }
}