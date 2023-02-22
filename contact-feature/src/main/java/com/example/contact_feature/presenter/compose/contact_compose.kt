package com.example.contact_feature.presenter.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.contact_feature.domain.state.ContactScreenFailState
import com.example.contact_feature.domain.state.ContactScreenLoadingState
import com.example.contact_feature.domain.state.ContactScreenSuccessState
import com.example.contact_feature.presenter.ContactViewModel

@Composable
fun ContactCompose(viewModel: ContactViewModel = viewModel()) {
    when (val state = viewModel.uiState.collectAsState().value) {
        is ContactScreenSuccessState -> ContactScreenSuccessCompose(
            state,
            viewModel::onContactClick,
            viewModel::onRefresh
        )
        is ContactScreenLoadingState -> ContactScreenLoadingCompose()
        is ContactScreenFailState -> ContactScreenFailCompose(viewModel::onRetryClick)
    }
}

