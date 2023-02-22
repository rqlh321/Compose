package com.example.contact_feature.domain.sideeffect

import com.example.contact_feature.domain.state.ContactScreenFailState
import com.example.contact_feature.domain.state.ContactScreenState

object LoadingFailContactSideEffect : ContactSideEffect() {
    override fun reduce(state: ContactScreenState) = ContactScreenFailState
}