package com.htbeyond.studying.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("stuying-boot", url = "http://localhost:9090/basic")
interface FeignService {
    @RequestMapping(method = [RequestMethod.GET], value = ["/todo"])
    fun testClient(@RequestParam("todo") todo: String): Any
}