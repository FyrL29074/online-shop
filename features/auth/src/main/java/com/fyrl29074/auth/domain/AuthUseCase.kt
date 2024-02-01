package com.fyrl29074.auth.domain

interface AuthUseCase {
    suspend fun auth(name: String, surname: String, phone: String)
}