package com.htbeyond.studying.controller

import com.htbeyond.studying.model.Todo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/basic")
class TodoContorller() {
    val counter = AtomicLong()
    @GetMapping("/todo")
    fun getTodo(@RequestParam("todo") todo: String) = Todo(counter.incrementAndGet(), todo)
}