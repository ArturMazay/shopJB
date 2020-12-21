package com.example.finishjb

import java.io.Serializable

data class CartModel(
    val title: String?,
    val description: String?,
    val totalPrice: String?,
    val image: String?
):Serializable {
}