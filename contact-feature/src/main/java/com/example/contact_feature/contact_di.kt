package com.example.contact_feature

import com.example.core.pattern.Reducer
import com.example.core.pattern.ReducerImpl
import com.example.contact_feature.domain.action.LoadContactsAction
import com.example.contact_feature.domain.action.RefreshContactsAction
import com.example.contact_feature.domain.action.impl.LoadContactsActionImpl
import com.example.contact_feature.domain.action.impl.RefreshContactsActionImpl
import com.example.contact_feature.domain.state.ContactScreenLoadingState
import com.example.contact_feature.domain.state.ContactScreenState
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Module
@InstallIn(ViewModelComponent::class)
object MainProvides {

    @Provides
    @ViewModelScoped
    fun mutableState(): MutableStateFlow<ContactScreenState> = MutableStateFlow(
        ContactScreenLoadingState
    )

    @Provides
    @ViewModelScoped
    fun state(
        mutableState: MutableStateFlow<ContactScreenState>
    ): StateFlow<ContactScreenState> = mutableState.asStateFlow()
}

@Module
@InstallIn(ViewModelComponent::class)
interface MainBinds {

    @Binds
    @ViewModelScoped
    fun reducer(impl: ReducerImpl<ContactScreenState>): Reducer<ContactScreenState>

    @Binds
    @ViewModelScoped
    fun load(impl: LoadContactsActionImpl): LoadContactsAction

    @Binds
    @ViewModelScoped
    fun refresh(impl: RefreshContactsActionImpl): RefreshContactsAction

}