package com.cicd.webapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class WebapiApplication

fun main(args: Array<String>) {
	runApplication<WebapiApplication>(*args)
}

@RestController
class HelloController {
	@GetMapping("/hello")
	fun sayHello(): String {
		return "Hello CI/CD World!"
	}
}

@RestController
class HealthController {
	@GetMapping("/health")
	fun healthCheck(): String {
		return "Server healthy!"
	}
}