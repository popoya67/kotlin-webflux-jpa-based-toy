package com.sujin.toy.service

import com.sujin.toy.entity.User
import com.sujin.toy.repository.UserRepository
import javassist.NotFoundException
import jdk.nashorn.internal.runtime.regexp.joni.Config.log
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers

@Service
class UserService(val userRepository: UserRepository) {

    fun register(user: User) = Mono.fromCallable {
        userRepository.save(user)
    }.subscribeOn(Schedulers.parallel())

    fun findAll() = Mono.fromCallable {
        userRepository.findAll()
    }.subscribeOn(Schedulers.parallel())
    .flatMapMany { Flux.fromIterable(it) }

    /* 다음 코드는 블로킹되니 사용하면 안됨.
    fun findAll() = Flux.fromIterable(
            userRepository.findAll()
    ).subscribeOn(Schedulers.parallel())
    */

    fun findById(id: Long) =
     Mono.fromCallable {
        userRepository.findById(id)
    }.subscribeOn(Schedulers.parallel())

    fun update(user: User) = Mono.fromCallable {
        userRepository.save(user)
    }.subscribeOn(Schedulers.parallel())

    fun delete(id: Long) = Mono.fromCallable {
        userRepository.deleteById(id)
    }.subscribeOn(Schedulers.parallel())
}