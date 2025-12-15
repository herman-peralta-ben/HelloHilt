package com.example.hellohilt.feature.external_counter.di

import com.example.hellohilt.feature.external_counter.ExternalCounterImpl
import com.example.mylibrary.examples.counter.ExternalCounter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Hilt module that binds [com.example.mylibrary.examples.counter.ExternalCounter] to its concrete implementation.
 *
 * This module must be defined in the host application (`app`), since the
 * application owns the concrete implementation ([com.example.hellohilt.feature.external_counter.ExternalCounterImpl]). Library
 * modules should only declare the contract ([com.example.mylibrary.examples.counter.ExternalCounter]) and depend
 * on it via injection.
 *
 * The module can be defined in two different ways depending on how the
 * implementation instance is created:
 *
 * - Use an `abstract class` with `@Binds` when the implementation has an
 *   `@Inject` constructor and Hilt can create the instance automatically.
 *
 * - Use an `object` module with `@Provides` when the instance must be created
 *   manually (for example, when passing constructor parameters or using
 *   factory logic).
 *
 * The binding is installed in [dagger.hilt.components.SingletonComponent], making it available to
 * all child components (Activity, ViewModel, Service, etc.).
 *
 * Note: Being installed in [dagger.hilt.components.SingletonComponent] does NOT imply singleton
 * lifetime unless `@Singleton` is explicitly used.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class ExternalCounterModule {

    companion object {
        /**
         * Uses @Provides because the instance is created manually
         * (for example, to pass constructor parameters).
         */
        @Provides
        fun provideCounter(): ExternalCounter = ExternalCounterImpl(
            initialValue = 0,
        )
    }

    /**
     * Uses [dagger.Binds.@Binds] to let Hilt create [ExternalCounterImpl] automatically via
     * constructor injection.
     * @Binds abstract fun bindCounter(impl: CounterImpl): Counter
     */
}
