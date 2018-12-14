package com.htbeyond.studying

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class StudyingSpringBootApplication

fun main(args: Array<String>) {
    runApplication<StudyingSpringBootApplication>(*args)
}