package com.woogie.study

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxCoroutineStudyApplication

fun main(args: Array<String>) {
    runApplication<WebfluxCoroutineStudyApplication>(*args)
}
