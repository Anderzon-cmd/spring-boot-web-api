package com.cicd.webapi

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc

@SpringBootTest
@AutoConfigureMockMvc
class WebapiApplicationTests {

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun contextLoads() {
	}

	@Test
	fun checkHealthyResponse() {
		mockMvc.perform(get("/health")
			.accept(MediaType.TEXT_PLAIN))
			.andExpect { status().isOk() }
			.andExpect { content().string("Server healthy!") }
	}
}
