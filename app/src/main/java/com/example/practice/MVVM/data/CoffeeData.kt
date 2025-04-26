package com.example.practice.MVVM.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coffee")
data class CoffeeData(
    @PrimaryKey
    @SerializedName("coffee_id") val id: String,

    @SerializedName("name") val title: String,
    @SerializedName("desc_1") val description: String,
    @SerializedName("roaster") val roaster: String?,
    @SerializedName("roast") val roast: String,
    @SerializedName("loc_country") val location: String?,
    @SerializedName("origin_1") val origin1: String?,
    @SerializedName("origin_2") val origin2: String?,
    @SerializedName("100g_USD") val price: String?,
    @SerializedName("rating") val rating: String?,
    @SerializedName("review_date") val reviewDate: String,
    @SerializedName("desc_2") val description2: String,
    @SerializedName("desc_3") val description3: String?
)
