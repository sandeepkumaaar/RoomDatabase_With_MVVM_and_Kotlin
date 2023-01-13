package com.example.mvvmdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Adapter.UserAdapter
import com.example.mvvmdemo.Model.User
import com.example.mvvmdemo.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var etName: EditText
    private lateinit var etAge: EditText
    private lateinit var etMobileNumber: EditText
    private lateinit var etEmailId: EditText
    private lateinit var btnSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        etName = findViewById(R.id.et_name)
        etAge = findViewById(R.id.et_age)
        etMobileNumber = findViewById(R.id.et_mobileNumber)
        etEmailId = findViewById(R.id.et_emailId)
        btnSubmit = findViewById(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            saveDataInRoomDB()
        }
    }

    private fun saveDataInRoomDB() {
        val mName = etName.text.toString().trim()
        val mAge = etAge.text.toString().trim()
        val mMobileNumber = etMobileNumber.text.toString().trim()
        val mEmailId = etEmailId.text.toString().trim()

        if (!TextUtils.isEmpty(mName) && !TextUtils.isEmpty(mAge)
            && !TextUtils.isEmpty(mMobileNumber) && !TextUtils.isEmpty(mEmailId)){

            userViewModel.insert(this, User(mName,Integer.parseInt(mAge),mMobileNumber,mEmailId))
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            clearCredentials()

        }else{
            Toast.makeText(applicationContext, "Please fill the details", Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearCredentials(){
        etName.text.clear()
        etAge.text.clear()
        etMobileNumber.text.clear()
        etEmailId.text.clear()
    }
}