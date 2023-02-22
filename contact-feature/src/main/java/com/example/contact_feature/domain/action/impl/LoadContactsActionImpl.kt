package com.example.contact_feature.domain.action.impl

import com.example.contact_feature.domain.action.LoadContactsAction
import com.example.personal_data_api.ContactRepo
import com.example.contact_feature.domain.sideeffect.LoadingContactSideEffect
import com.example.contact_feature.domain.sideeffect.LoadingFailContactSideEffect
import com.example.contact_feature.domain.sideeffect.LoadingSuccessContactSideEffect
import com.example.contact_feature.domain.state.ContactScreenState
import com.example.core.pattern.Reducer
import javax.inject.Inject

class LoadContactsActionImpl @Inject constructor(
    private val contactRepo: ContactRepo,
    private val reducer: Reducer<@JvmSuppressWildcards ContactScreenState>,
) : LoadContactsAction {

    override suspend fun execute() {
        try {
            reducer.reduce(LoadingContactSideEffect)
            val contacts = contactRepo.all()
            reducer.reduce(LoadingSuccessContactSideEffect(contacts))
        } catch (e: Exception) {
            reducer.reduce(LoadingFailContactSideEffect)
        }
    }

}