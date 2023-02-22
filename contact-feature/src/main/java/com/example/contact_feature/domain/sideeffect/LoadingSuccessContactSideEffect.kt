package com.example.contact_feature.domain.sideeffect

import com.example.personal_data_api.model.Contact
import com.example.contact_feature.domain.state.ContactScreenState
import com.example.contact_feature.domain.state.ContactScreenSuccessState

data class LoadingSuccessContactSideEffect(
    private val contacts: List<Contact>
) : ContactSideEffect() {
    override fun reduce(state: ContactScreenState) = ContactScreenSuccessState(
        contacts = contacts
    )
}