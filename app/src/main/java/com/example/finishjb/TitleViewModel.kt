package com.example.finishjb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class TitleViewModel : ViewModel() {

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("product")
    private val repository = Repository()

    fun transferToView(): LiveData<MutableList<Product>>{
            val mutableList = MutableLiveData<MutableList<Product>>()
            repository.loadList().observeForever { listProduct->
                    mutableList.value=listProduct
            }
            return mutableList

    }

    fun addCart(product: Product ){
        myRef.setValue(product)
    }

}