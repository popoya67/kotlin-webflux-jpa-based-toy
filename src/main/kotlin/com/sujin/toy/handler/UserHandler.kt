package com.sujin.toy.handler

import com.sujin.toy.entity.User
import com.sujin.toy.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body

@Component
class UserHandler(val userService: UserService) {
    fun register(serverRequest: ServerRequest) = serverRequest.bodyToMono(User::class.java).map {
        userService.register(it)
    }.flatMap {
        ServerResponse.ok().body(it)
    }

    fun findAll(serverRequest: ServerRequest)  = ServerResponse.ok().body(userService.findAll())
}