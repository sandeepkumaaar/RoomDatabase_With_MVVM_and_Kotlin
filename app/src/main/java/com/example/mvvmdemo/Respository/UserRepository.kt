package com.example.mvvmdemo.Respository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.mvvmdemo.Database.UserDatabase
import com.example.mvvmdemo.Model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UserRepository  {

    companion object {
        private var userDatabase: UserDatabase?=null
        fun initializeDB(context: Context): UserDatabase? {
            return UserDatabase.getInstance(context)
        }

        fun insert(context: Context, user:User) {
            userDatabase = initializeDB(context)
            CoroutineScope(IO).launch {
                userDatabase?.getDao()?.insert(user)
            }
        }

        fun getAllUserData(context: Context): LiveData<List<User>>? {
            userDatabase = initializeDB(context)
            return userDatabase?.getDao()?.getAllUserData()
        }
    }
}