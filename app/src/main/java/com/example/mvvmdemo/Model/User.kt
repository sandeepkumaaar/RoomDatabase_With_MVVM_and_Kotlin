package com.example.mvvmdemo.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    val name: String,
    val age: Int,
    val mobileNumber: String,
    val emailId: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}