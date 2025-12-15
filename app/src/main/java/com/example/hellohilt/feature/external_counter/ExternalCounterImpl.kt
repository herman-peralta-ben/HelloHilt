package com.example.hellohilt.feature.external_counter

import com.example.mylibrary.examples.counter.ExternalCounter
import javax.inject.Inject

/**
 * Implements [ExternalCounter] from `mylibrar` module.
 */
class ExternalCounterImpl @Inject constructor(
    private var initialValue: Int,
) : ExternalCounter {

    override val value: Int
        get() = initialValue

    override fun increment() = initialValue++

    override fun decrement() = initialValue--
}
