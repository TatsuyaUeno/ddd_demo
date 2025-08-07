package com.example.demo.demo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
    }

    @Test
    fun postTestMessage() {
        mockMvc.perform(post("/api/test/message"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello, this is a test message!"))
    }
}
