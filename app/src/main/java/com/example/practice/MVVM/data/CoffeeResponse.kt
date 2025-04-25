package com.example.practice.MVVM.data

import com.google.gson.annotations.SerializedName

data class CoffeeResponse(
    @SerializedName("records") val records: List<CoffeeData>
)
