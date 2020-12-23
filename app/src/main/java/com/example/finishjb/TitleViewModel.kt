package com.example.finishjb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {


    private val repository = Repository()

    fun transferToView(): LiveData<MutableList<Product>>{
            val mutableList = MutableLiveData<MutableList<Product>>()
            repository.loadList().observeForever { listProduct->
                    mutableList.value=listProduct
            }
            return mutableList

    }


    /* private val firebaseFirestone: FirebaseFirestore = FirebaseFirestore.getInstance()
     val product: MutableLiveData<MutableList<Product>> = MutableLiveData()
    *//* val modelLiveData: LiveData<MutableList<Product>>
        get() = product

    init {
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
                product.value = listData
            }
    }*//*

    *//*fun addToCart() {
        myRef.setValue()
    }*//*
*/
}