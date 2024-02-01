package com.fyrl29074.auth.presentation

sealed class AuthState {
    data object Waiting : AuthState()

    data object Loading : AuthState()
    data object Success : AuthState()
    data class Error(val message: String) : AuthState()
}