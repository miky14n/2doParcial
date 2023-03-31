package com.example.segundoparcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(val items: ArrayList<Post>, val context: Context): RecyclerView.Adapter<UserListAdapter.UserListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.basic_info_row, parent, false)
        return UserListViewHolder(v)
    }
    override fun getItemCount(): Int {
        return items.count()
    }
    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val item = items.get(position)
        holder.itemView.findViewById<TextView>(R.id.tv_title).text = item.title
        holder.itemView.findViewById<TextView>(R.id.tv_description).text = item.body

    }
    class UserListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}
