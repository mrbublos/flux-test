package me

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration
import io.r2dbc.postgresql.PostgresqlConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

fun main(vararg args: String) {
    SpringApplication.run(Application::class.java, *args)
}

@ComponentScan(basePackages = ["me.app"])
@EnableAutoConfiguration(exclude = [R2dbcAutoConfiguration::class])
@Import(DbConfig::class)
open class Application

@Configuration
@EnableR2dbcRepositories
open class DbConfig : AbstractR2dbcConfiguration() {

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return PostgresqlConnectionFactory(
            PostgresqlConnectionConfiguration.builder()
                .host("localhost")
                .port(5432)  // optional, defaults to 5432
                .username("test")
                .password("test")
                .database("test")  // optional
                .schema("test")
                .build())
    }
}