package com.example.demo.demo.controller

import com.example.demo.demo.domain.model.TrnTest
import com.example.demo.demo.service.TestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/test")
class TestController {
    @Autowired
    private lateinit var testService: TestService

    @GetMapping("/message")
    fun getTestMessage(): String {
        return "Hello, this is a test message!"
    }

    @PostMapping("getUser")
    fun getUser(): TrnTest {
        return testService.findByUserId("001")
    }

    @PostMapping("createUser")
    fun createUser(): TrnTest {
        return testService.createUser("003", "api-user")
    }

    @PostMapping("getUserToPlainSQL")
    fun getUserToPlainSQL(): TrnTest? {
        return testService.findByUserIdToPlainSQL("003")
    }

    @PostMapping("exception")
    fun exception(): String {
        throw IllegalStateException("This is a test exception")
    }
}
