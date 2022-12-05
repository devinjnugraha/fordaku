package com.fordaku.bind

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.fordaku.model.Posts
import com.fordaku.R
import com.google.firebase.firestore.CollectionReference
import kotlinx.android.synthetic.main.recyclerview_layout2.view.*
import java.text.SimpleDateFormat
import java.util.*

class ProfilePostAdapter(
    private val context: Context,
    private val collection: CollectionReference,
    options: FirestoreRecyclerOptions<Posts>
) : FirestoreRecyclerAdapter<Posts, ProfilePostAdapter.PostsViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_layout2, parent, false)
        )
    }

    override fun onBindViewHolder(viewHolder: PostsViewHolder, position: Int, posts: Posts) {
        viewHolder.bindItem(posts)
    }

    class PostsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(posts: Posts) {
            view.apply {
                tvPostTitle.text = posts.strTitle
                tvPostDate.text =
                    SimpleDateFormat("dd MMMM yyyy, hh:mm").format(Date(posts.intCreatedAt.toLong() * 1000))
                tvPostFordaName.text = "Acri"
            }
        }
    }
}