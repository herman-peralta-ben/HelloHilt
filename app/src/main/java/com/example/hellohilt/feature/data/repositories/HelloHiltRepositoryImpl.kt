package com.example.hellohilt.feature.data.repositories

import com.example.hellohilt.feature.domain.repositories.HelloHiltRepository

class HelloHiltRepositoryImpl: HelloHiltRepository {
    private var count = 0
    override fun increment(): Int {
        count += 1
        return count
    }
}
