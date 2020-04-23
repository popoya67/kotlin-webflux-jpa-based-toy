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

    @GetMapping("users/{id}")
    fun getUser(@PathVariable id: Long) = userService.findById(id)

    @PutMapping("user/{id}")
    fun updateUser(@RequestBody user: User) = userService.update(user)

    @DeleteMapping("user/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.delete(id)
}