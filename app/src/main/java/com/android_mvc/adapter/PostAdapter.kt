package com.android_mvc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android_mvc.MainActivity
import com.android_mvc.R
import com.android_mvc.model.Post

class PostAdapter (var activity: MainActivity, var items:ArrayList<Post>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val post: Post = items[position]

        if (holder is PostViewHolder){
            val ll_post = holder.ll_post
            ll_post.setOnLongClickListener {
                activity.deletePostDialog(post)
                false
            }
            holder.tv_title.setText(post.title.toUpperCase())
            holder.tv_body.setText(post.body)

        }
    }



    override fun getItemCount(): Int {
        return items.size
    }

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view){
        var ll_post: LinearLayout = view.findViewById(R.id.ll_post)
        var tv_title : TextView = view.findViewById(R.id.tv_title)
        var tv_body : TextView = view.findViewById(R.id.tv_body)


    }
}