package com.sujin.toy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ToyApplication

fun main(args: Array<String>) {
	runApplication<ToyApplication>(*args)
}
