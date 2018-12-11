package com.htbeyond.studying.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController {
    @GetMapping("")
    fun rootGet(): Map<String, Int> = mapOf("a" to 1, "b" to 2, "c" to 3)
}