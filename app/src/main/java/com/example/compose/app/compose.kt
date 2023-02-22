package com.example.compose.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.ui.Shimmer
import com.example.ui.SmallItemLoadingCompose

@Preview
@Composable
fun preview() {
    Shimmer {
        SmallItemLoadingCompose(brush = it)
    }
}