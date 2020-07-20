package br.com.djefferson

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCurriculumRestApplication

fun main(args: Array<String>) {
	runApplication<KotlinCurriculumRestApplication>(*args)
}
