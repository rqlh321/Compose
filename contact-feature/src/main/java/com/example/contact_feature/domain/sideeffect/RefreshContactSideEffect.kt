package com.example.contact_feature.domain.sideeffect

import com.example.contact_feature.domain.state.ContactScreenState
import com.example.contact_feature.domain.state.ContactScreenSuccessState

object RefreshContactSideEffect : ContactSideEffect() {
    override fun reduce(state: ContactScreenState) = (state as ContactScreenSuccessState).copy(
        isRefreshing = true
    )
}