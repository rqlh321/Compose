package com.example.contact_feature.domain.sideeffect

import com.example.contact_feature.domain.state.ContactScreenLoadingState
import com.example.contact_feature.domain.state.ContactScreenState

object LoadingContactSideEffect : ContactSideEffect() {
    override fun reduce(state: ContactScreenState) = ContactScreenLoadingState
}