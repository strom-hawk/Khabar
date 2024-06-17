package com.example.khabar.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.khabar.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Loren ipsum is simply dummy",
        description = "Loren ipsum is simply dummy with Description 1",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Loren ipsum is simply dummy with Title 2",
        description = "Loren ipsum is simply dummy with Description 2",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Loren ipsum is simply dummy with Title 3",
        description = "Loren ipsum is simply dummy with Description 3",
        image = R.drawable.onboarding3
    )
)
