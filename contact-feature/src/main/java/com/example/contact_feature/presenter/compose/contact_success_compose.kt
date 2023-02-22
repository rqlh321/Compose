package com.example.contact_feature.presenter.compose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contact_feature.R
import com.example.contact_feature.domain.state.ContactScreenSuccessState
import com.example.personal_data_api.model.Contact
import com.example.ui.SmallItem
import com.example.ui.SmallItemCompose
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import java.util.*

@Preview
@Composable
fun MainScreenSuccessComposePreview() {
    ContactScreenSuccessCompose(
        ContactScreenSuccessState((0..10).map {
            Contact(
                id = it.toString(),
                imageUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9a/Gull_portrait_ca_usa.jpg",
                name = UUID.randomUUID().toString()
            )
        })
    )
}

@Composable
internal fun ContactScreenSuccessCompose(
    state: ContactScreenSuccessState,
    onContactClick: (String) -> Unit = { Log.i("MainScreen", "onContactClick") },
    onRefresh: () -> Unit = { Log.i("MainScreen", "onRefresh") },
) {
    val items = state.contacts.map { contact ->
        SmallItem(
            id = contact.id,
            imageUrl = contact.imageUrl,
            imageDescription = stringResource(R.string.contact_avatar_description),
            title = contact.name,
        )
    }
    SwipeRefresh(
        state = rememberSwipeRefreshState(state.isRefreshing),
        onRefresh = onRefresh,
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(
                items = items,
                key = { it.id }
            ) { item ->
                SmallItemCompose(
                    item = item,
                    onItemClick = onContactClick
                )
            }
        }
    }
}