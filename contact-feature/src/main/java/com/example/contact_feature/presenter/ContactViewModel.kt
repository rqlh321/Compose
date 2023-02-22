package com.example.contact_feature.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contact_feature.domain.action.LoadContactsAction
import com.example.contact_feature.domain.action.RefreshContactsAction
import com.example.contact_feature.domain.state.ContactScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    val uiState: StateFlow<@JvmSuppressWildcards ContactScreenState>,
    private val loadAction: LoadContactsAction,
    private val refreshAction: RefreshContactsAction,
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.Unconfined) {
            loadAction.execute()
        }
    }

    fun onContactClick(id: String) {
        println(id)
    }

    fun onRetryClick() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            loadAction.execute()
        }
    }

    fun onRefresh() {
        viewModelScope.launch(Dispatchers.Unconfined) {
            refreshAction.execute()
        }
    }
}
