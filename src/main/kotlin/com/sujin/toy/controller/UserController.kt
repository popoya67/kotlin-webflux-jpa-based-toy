package com.sujin.toy.controller

import com.sujin.toy.entity.User
import com.sujin.toy.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("test")
class UserController(val userService: UserService) {

    @PostMapping("user/register")
    fun register(@RequestBody user: User) = userService.register(user)

    @GetMapping("users")
    fun getAll() =  userService.findAll()
}