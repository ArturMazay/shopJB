package com.example.finishjb

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val onClickTo: OnClickTo) : RecyclerView.Adapter<MyViewHolder>() {

    var data = mutableListOf<Product>()
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder =
            MyViewHolder(itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_title, parent, false))


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            //val data = data[position]
            onClickTo.onClickAddCart()
        }

    }

    override fun getItemCount(): Int = data.size
}