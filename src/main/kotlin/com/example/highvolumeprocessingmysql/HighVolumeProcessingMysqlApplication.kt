package com.example.highvolumeprocessingmysql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class HighVolumeProcessingMysqlApplication

fun main(args: Array<String>) {
    runApplication<HighVolumeProcessingMysqlApplication>(*args)
}
