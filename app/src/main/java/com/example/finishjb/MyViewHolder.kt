package com.example.finishjb


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import life.sabujak.roundedbutton.RoundedButton

class MyViewHolder(itemView: View,onClickTo: OnClickTo) : RecyclerView.ViewHolder(itemView) {
    
    private lateinit var model:Product//так? интерфейс туда положил?

    private val count: TextView = itemView.findViewById(R.id.tv_count)
    private val mprice: TextView = itemView.findViewById(R.id.tv_price)
    private val totalPrice: TextView = itemView.findViewById(R.id.tv_total_price)
    private val image: ImageView = itemView.findViewById(R.id.iv_image)
    private val description: TextView = itemView.findViewById(R.id.tv_description)

    private val plus_btn: RoundedButton = itemView.findViewById(R.id.btn_plus)
    private val minus_btn: RoundedButton = itemView.findViewById(R.id.btn_minus)
    private val btnAddCart: RoundedButton = itemView.findViewById(R.id.roundedButton)

    private var mCount: Int = 0
    private var mPrice: Int? = null

    fun bind(model: Product) {
        this.model=model   //так ?

        Glide.with(itemView.context).load(model.image).into(image)
        description.text = model.description
        mprice.text = model.price

        minus_btn.setOnClickListener {
            mCount++
            count.text = mCount.toString()
            mPrice = mCount * 76
            totalPrice.text = mPrice.toString()
        }

        plus_btn.setOnClickListener {
            mCount--
            if (mCount >= 0) {
                count.text = mCount.toString()
                mPrice = mCount * 76
                totalPrice.text = mPrice.toString()
            } else mCount = 0
        }
    }
    init {
        btnAddCart.setOnClickListener { onClickTo.onClickAddCart(model) }
    }
}