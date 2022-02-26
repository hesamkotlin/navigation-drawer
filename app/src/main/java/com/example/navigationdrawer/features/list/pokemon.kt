package com.example.navigationdrawer.features.list

import androidx.annotation.DrawableRes

data class Pokemon(
    val id : Int,
    @DrawableRes val image: Int,
    val title: String,
    val description: String
)

