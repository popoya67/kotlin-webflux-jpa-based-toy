package com.sujin.toy.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        var id: Long,

        var name: String,

        var age: Int
){}