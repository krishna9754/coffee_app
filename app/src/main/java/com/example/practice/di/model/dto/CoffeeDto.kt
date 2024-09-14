package com.example.practice.di.model.dto

data class CoffeeDto(
    val description: String,
    val id: Int,
    val image: String,
    val ingredients: List<String>,
    val title: String
)