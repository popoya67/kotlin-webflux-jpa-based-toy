package com.sujin.toy.service

import com.sujin.toy.entity.User
import com.sujin.toy.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class UserService(val userRepository: UserRepository) {

    fun register(user: User) = Mono.just(userRepository.save(user))

    fun findAll() = Flux.just(userRepository.findAll())
}