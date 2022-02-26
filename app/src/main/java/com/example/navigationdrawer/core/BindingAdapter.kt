package com.example.navigationdrawer.core

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("android:src")
fun bindImageDrawable(imageView: ImageView , drawable: Drawable?){
    imageView.setImageDrawable(drawable)
}

@BindingAdapter("android:src")
fun bindImageresource(imageView: ImageView , resource : Int){
    imageView.setImageResource(resource)
}
