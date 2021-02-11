package com.example.simplesearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MainAdapter(var dataList : List<Article>, var mainActivity: MainActivity) : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_search,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.itemView.apply {
            val textTitle = findViewById<TextView>(R.id.textItem)
            val imgNews = findViewById<ImageView>(R.id.imgItem)

            textTitle.text = dataList[position].title

            Picasso.get().load(dataList[position].urlToImage).into(imgNews)

        }

    }

    override fun getItemCount(): Int {
       return dataList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}