package com.example.contact_feature.domain.state

import com.example.personal_data_api.model.Contact

data class ContactScreenSuccessState(
    val contacts: List<Contact> = emptyList(),
    val isRefreshing: Boolean = false
) : ContactScreenState()