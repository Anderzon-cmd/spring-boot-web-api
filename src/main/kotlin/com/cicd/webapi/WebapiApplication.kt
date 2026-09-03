package com.cicd.webapi

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Properties

@SpringBootApplication
//@EnableConfigurationProperties(AppProperties::class)
class WebapiApplication

fun main(args: Array<String>) {
	runApplication<WebapiApplication>(*args)
}
//
//@ConfigurationProperties(prefix="app")
//data class AppProperties(
//	val instance: String="unknown"
//)

@RestController
class HelloController(
    @Value($$"${server.port:8080}") private val port: String,
	@Value($$"${app.instance:unknown}") private val instance: String
){

	@GetMapping("/")
	fun sayHello(): String {
		return "Hello CI/CD World!"
	}

	@GetMapping("/instance")
	public fun instance(): Map<String, String>{
		return mapOf(
			"port" to port,
			"instance" to instance
		)
	}
}

@RestController
class HealthController {
	@GetMapping("/health")
	fun healthCheck(): String {
		return "Server healthy!"
	}
}

@RestController
class DateController {
	@GetMapping("/date")
	fun getCurrentDate(): String {
		return "Current date and time: ${java.time.LocalDate.now()}"
	}
}