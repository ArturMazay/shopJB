package com.example.finishjb

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class TitleViewModel : ViewModel() {

    private val firebaseFirestone: FirebaseFirestore = FirebaseFirestore.getInstance()
    val product: MutableLiveData<MutableList<Product>> = MutableLiveData()
    val modelLiveData: LiveData<MutableList<Product>>
        get() = product

    init {
        FirebaseFirestore.getInstance().collection("Product").get()
            .addOnSuccessListener { result ->
                val listData = mutableListOf<Product>()
                for (document in result) {
                    val image: String = document.getString("image") ?: ""
                    Log.e("XXX", image)
                    val title: String = document.getString("title") ?: ""
                    val price: String = document.getString("price") ?: ""
                    val description: String = document.getString("description") ?: ""

                    val product = Product(
                        title, image, description, price
                    )
                    listData.add(product)
                }
                product.value = listData
            }
    }

}