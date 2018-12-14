package com.htbeyond.studying.service

import org.springframework.stereotype.Service

@Service
class TestClientService(private val feignService: FeignService) {
    fun getTestInfo()= feignService.testClient("안녕맨") as Map<String, String>

}