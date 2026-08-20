package com.cicd.webapi

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.mockStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.context.ConfigurableApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
class WebapiApplicationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun contextLoads() {
    }

    @Test
    fun main_shouldStartApplication() {
        val args = emptyArray<String>()

        val context=mock(ConfigurableApplicationContext::class.java)


        mockStatic(SpringApplication::class.java).use {mocked->
            mocked.`when`<ConfigurableApplicationContext> {
                SpringApplication.run(
                    WebapiApplication::class.java,
                    *args
                )
            }.thenReturn(context)

            main(args)

            mocked.verify {
                SpringApplication.run(
                    WebapiApplication::class.java,
                    *args
                )
            }
        }
    }

    @Test
    fun checkHelloResponse() {
        mockMvc.perform(
            get("/")
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(status().isOk())
            .andExpect(content().string("Hello CI/CD World!"))
    }

    @Test
    fun checkHealthyResponse() {
        mockMvc.perform(
            get("/health")
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(status().isOk())
            .andExpect(content().string("Server healthy!"))
    }

    @Test
    fun checkDateResponse() {
        mockMvc.perform(
            get("/date")
                .accept(MediaType.TEXT_PLAIN)
        )
            .andExpect(status().isOk())
            .andExpect(content().string("Current date and time: ${java.time.LocalDate.now()}"))
    }

}
