package com.example.compose.app

import com.example.compose.R

enum class RootScreen(
    val route: String,
    val resourceId: Int,
) {
    Contacts(
        route = this::class.java.name,
        resourceId = R.string.screen_label_contacts,
    );
}

