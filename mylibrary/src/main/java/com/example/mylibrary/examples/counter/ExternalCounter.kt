package com.example.mylibrary.examples.counter

/**
 * [ExternalCounter] contract to be implemented and provided by the host application.
 *
 * Bound in Hilt so it can be injected into [ExternalCounterViewModel].
 */
interface ExternalCounter {
    val value: Int
    fun increment(): Int
    fun decrement(): Int
}
