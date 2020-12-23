package com.example.finishjb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore

class Repository {


    fun loadList(): LiveData<MutableList<Product>> {
        val mutableData = MutableLiveData<MutableList<Product>>()
        FirebaseFirestore.getInstance().collection("Product").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Product>()
                for (document in result) {
                    val image: String = document.getString("image") ?: ""
                    val title: String = document.getString("title") ?: ""
                    val price: String = document.getString("price") ?: ""
                    val description: String = document.getString("description") ?: ""

                    val product = Product(
                        title, image, description, price
                    )
                    listData.add(product)
                }
                mutableData.value = listData
            }
             return mutableData

    }

}