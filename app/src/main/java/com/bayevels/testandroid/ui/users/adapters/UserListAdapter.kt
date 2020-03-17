package com.bayevels.testandroid.ui.users.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayevels.testandroid.R
import com.bayevels.testandroid.data.model.User
import kotlinx.android.synthetic.main.user_item.view.*

class UserListAdapter(private val users: List<User>) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(getItem(position))
    }

    private fun getItem(position: Int): User{
        return users[position]
    }

    class UserViewHolder(var view: View): RecyclerView.ViewHolder(view){

        fun bindUser(user: User) {
            with(user){
                itemView.user_name.text = name
                itemView.user_email.text = email
                itemView.company_name.text = company?.name
                itemView.user_phone.text = phone
                itemView.user_website.text = website
                itemView.user_address.text = "${address?.street}, ${address?.suite}, ${address?.city}"
            }
        }
    }
}