package com.example.contact_feature.presenter.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contact_feature.R

@Preview
@Composable
fun MainScreenFailComposePreview() {
    ContactScreenFailCompose {

    }
}

@Composable
internal fun ContactScreenFailCompose(
    onRetryClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp),
    ) {
        Text(
            text = stringResource(R.string.main_screen_error_title),
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = { onRetryClick.invoke() },
            modifier = Modifier.padding(top = 8.dp),
        ) {
            Text(text = stringResource(R.string.main_screen_error_retry_button))
        }
    }
}