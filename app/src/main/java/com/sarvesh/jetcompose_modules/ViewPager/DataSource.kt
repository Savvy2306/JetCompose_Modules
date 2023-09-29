package com.sarvesh.jetcompose_modules.ViewPager

import androidx.annotation.DrawableRes
import com.sarvesh.jetcompose_modules.R

data class Pager(
    @DrawableRes val image:Int,
    val description:String
)

val dataList = listOf(
    Pager(R.drawable.page_one,"PAGE ONE"),
    Pager(R.drawable.page_two,"PAGE TWO"),
    Pager(R.drawable.page_one,"PAGE THREE")
)