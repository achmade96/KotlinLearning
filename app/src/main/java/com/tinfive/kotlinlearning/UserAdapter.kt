package com.tinfive.kotlinlearning

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class UserAdapter(val firstNames: Array<String>, val lastNames: Array<String>, val avatars: Array<String>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_layout, parent, false) as View

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return firstNames.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_firstname.text = firstNames[position]
        holder.tv_lastname.text = lastNames[position]
        Picasso.get()
            .load(avatars[position])
            .placeholder(R.mipmap.ic_launcher)
            .into(holder.iv_avatar)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tv_firstname = view.findViewById<TextView>(R.id.tv_first_name)
        val tv_lastname = view.findViewById<TextView>(R.id.tv_last_name)
        val iv_avatar = view.findViewById<ImageView>(R.id.iv_avatars)
    }
}
