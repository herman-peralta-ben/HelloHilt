package com.example.hellohilt.di

import com.example.hellohilt.feature.data.repositories.HelloHiltRepositoryImpl
import com.example.hellohilt.feature.domain.repositories.HelloHiltRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindScannerRepository(
        helloHiltRepository: HelloHiltRepositoryImpl
    ): HelloHiltRepository
}
