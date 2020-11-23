package dev.trile.iocdi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class IocdiApplication {

  @Bean
  fun primaryBank() = VietcomBank()

  @Bean
  fun secondaryBank() = VietinBank()

}

fun main(args: Array<String>) {
  runApplication<IocdiApplication>(*args)
}
