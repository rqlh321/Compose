package com.example.compose.app

import com.example.personal_data_impl.ContactRepoImpl
import com.example.personal_data_api.ContactRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {

    @Binds
    fun repo(impl: ContactRepoImpl): ContactRepo

}