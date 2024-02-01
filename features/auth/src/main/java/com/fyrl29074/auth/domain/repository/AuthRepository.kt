package com.fyrl29074.auth.domain.repository

interface AuthRepository {
    suspend fun auth(name: String, surname: String, phone: String)
}