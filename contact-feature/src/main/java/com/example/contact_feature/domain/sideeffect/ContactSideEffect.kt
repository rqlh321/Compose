package com.example.contact_feature.domain.sideeffect

import com.example.core.pattern.SideEffect
import com.example.contact_feature.domain.state.ContactScreenState

sealed class ContactSideEffect: SideEffect<ContactScreenState>()