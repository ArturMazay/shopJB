package com.example.finishjb

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    private val price:TextView=itemView.findViewById(R.id.tv_price)
    private val image:ImageView=itemView.findViewById(R.id.iv_image)
    private val description:TextView=itemView.findViewById(R.id.tv_description)
   // private val btnAddCart:Button=itemView.findViewById(R.id.roundedButton)


    fun bind(product: Product) {
        Glide.with(itemView.context).load(product.image).into(image)
        description.text = product.description
        price.text = product.price
    }

}
