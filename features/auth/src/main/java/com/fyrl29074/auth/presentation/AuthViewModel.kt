package com.fyrl29074.auth.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyrl29074.auth.domain.AuthUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authUseCase: AuthUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<AuthState>(AuthState.Waiting)
    val state = _state.asStateFlow()

    fun auth(name: String, surname: String, phone: String) {
        viewModelScope.launch {
            runCatching {
                authUseCase.auth(name, surname, phone)
            }.fold(
                onSuccess = {
                    _state.value = AuthState.Success
                },
                onFailure = { error ->
                    _state.value = AuthState.Error(error.message ?: "Unknown error")
                }
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}