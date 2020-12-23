package com.example.finishjb


import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.FirebaseDatabase
import life.sabujak.roundedbutton.RoundedButton

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("product")

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


    fun bind(product: Product) {
        Glide.with(itemView.context).load(product.image).into(image)
        description.text = product.description
        mprice.text = product.price

        btnAddCart.setOnClickListener {

            myRef.setValue(CartModel("image", "description", "", "jj"))
            Toast.makeText(itemView.context, "REEEEE", Toast.LENGTH_LONG).show()
        }

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
}