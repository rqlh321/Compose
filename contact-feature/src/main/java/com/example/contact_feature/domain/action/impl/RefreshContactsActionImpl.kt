package com.example.contact_feature.domain.action.impl

import com.example.contact_feature.domain.action.RefreshContactsAction
import com.example.personal_data_api.ContactRepo
import com.example.contact_feature.domain.sideeffect.LoadingFailContactSideEffect
import com.example.contact_feature.domain.sideeffect.RefreshContactSideEffect
import com.example.contact_feature.domain.sideeffect.RefreshSuccessContactSideEffect
import com.example.contact_feature.domain.state.ContactScreenState
import com.example.core.pattern.Reducer
import javax.inject.Inject

class RefreshContactsActionImpl @Inject constructor(
    private val contactRepo: ContactRepo,
    private val reducer: Reducer<@JvmSuppressWildcards ContactScreenState>,
) : RefreshContactsAction {

    override suspend fun execute() {
        try {
            reducer.reduce(RefreshContactSideEffect)
            val contacts = contactRepo.all()
            reducer.reduce(RefreshSuccessContactSideEffect(contacts))
        } catch (e: Exception) {
            reducer.reduce(LoadingFailContactSideEffect)
        }
    }

}