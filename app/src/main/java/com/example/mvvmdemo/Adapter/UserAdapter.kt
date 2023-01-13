package com.example.mvvmdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Model.User
import com.example.mvvmdemo.R

class UserAdapter(private var userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_card, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = userList[position]
        holder.userName.text = "Name:- ${user.name}"
        holder.userAge.text = "Age:- ${user.age}"
        holder.userMobileNumber.text = "Mobile No. :- ${user.mobileNumber}"
        holder.userEmailId.text = "Email:- ${user.emailId}"
    }

    fun setData(userList: ArrayList<User>){
        this.userList = userList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = userList.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val userName: TextView = itemView.findViewById(R.id.tv_name)
        val userAge: TextView = itemView.findViewById(R.id.tv_age)
        val userMobileNumber: TextView = itemView.findViewById(R.id.tv_mobileNumber)
        val userEmailId: TextView = itemView.findViewById(R.id.tv_emailId)

    }
}