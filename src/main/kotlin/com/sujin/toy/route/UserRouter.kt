package com.sujin.toy.route

import com.sujin.toy.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class UserRouter(private val userHandler: UserHandler) {

    @Bean
    fun userRoutes() = router{
        "/user".nest{
            POST("/register", userHandler::register)
        }
        "/users".nest{
            GET("", userHandler::findAll)
        }
    }
}