package com.example.contact_feature.presenter.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui.Shimmer
import com.example.ui.SmallItemLoadingCompose

@Preview
@Composable
fun MainScreenLoadingComposePreview() {
    ContactScreenLoadingCompose()
}

@Composable
internal fun ContactScreenLoadingCompose() {
    Shimmer { brush ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            repeat(3) {
                SmallItemLoadingCompose(brush)
            }
        }
    }
}