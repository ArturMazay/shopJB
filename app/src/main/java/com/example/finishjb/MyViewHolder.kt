package com.example.finishjb

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase
import life.sabujak.roundedbutton.RoundedButton

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val price: TextView = itemView.findViewById(R.id.tv_price)
    private val image: ImageView = itemView.findViewById(R.id.iv_image)
    private val description: TextView = itemView.findViewById(R.id.tv_description)
    private val btnAddCart: RoundedButton = itemView.findViewById(R.id.roundedButton)
    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("message hello world")


    fun bind(product: Product) {
        Glide.with(itemView.context).load(product.image).into(image)
        description.text = product.description
        price.text = product.price

        image.setOnClickListener {
            myRef.setValue("kfmkvmfkvmfdkvm")
        }
        btnAddCart.setOnClickListener {
            myRef.setValue("ya vasya")
        }
    }
}

