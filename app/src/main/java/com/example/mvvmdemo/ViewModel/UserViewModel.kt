package com.example.mvvmdemo.ViewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.Model.User
import com.example.mvvmdemo.Respository.UserRepository

class UserViewModel : ViewModel() {

    fun insert(context: Context, user: User){
        UserRepository.insert(context, user)
    }

    fun getAllUserData(context: Context): LiveData<List<User>>? {
        return UserRepository.getAllUserData(context)
    }
}