package com.example.zengarden.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zengarden.auth.data.auth_api.RegistrationRequestImpl
import com.example.zengarden.auth.data.auth_api.SuccessRegistrationResponseImpl


import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.domain.repository.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _state = MutableStateFlow<AuthState>(AuthState.SignUpState())
    val state = _state.asStateFlow()

    fun obtainEvent(event: AuthEvent) {
        when (_state.value) {
            is AuthState.SignUpState -> handleSighUpEvents(event)
            is AuthState.SignInState -> handleSighInEvents(event)
            is AuthState.IdleState -> {}
        }
    }

    private fun handleSighUpEvents(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnSignUpUsernameChanged -> {
                _state.value = (_state.value as AuthState.SignUpState).copy(username = event.value)
            }
            is AuthEvent.OnSignUpPasswordChanged -> {
                _state.value = (_state.value as AuthState.SignUpState).copy(password = event.value)
            }

            is AuthEvent.OnSignUpConfirmPasswordChanged -> {
                _state.value = (_state.value as AuthState.SignUpState).copy(confirmPassword = event.value)
            }

            AuthEvent.SubmitSignUp -> submitSignUp()

            AuthEvent.SwitchToSignIn -> _state.value = AuthState.SignInState()
            else -> {}
        }
    }

    private fun handleSighInEvents(event: AuthEvent) {
        when (event) {
            is AuthEvent.OnSignInUsernameChanged -> _state.value = (_state.value as AuthState.SignInState).copy(username = event.value)
            is AuthEvent.OnSignInPasswordChanged -> _state.value = (_state.value as AuthState.SignInState).copy(password = event.value)
            AuthEvent.SubmitSignIn -> submitSignIn()

            AuthEvent.SwitchToSignUp -> _state.value = AuthState.SignUpState()
            else -> {}
        }
    }


    private fun submitSignUp() {
        val currentState = _state.value as AuthState.SignUpState

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val registrationRequest = RegistrationRequestImpl(
                    username = currentState.username,
                    password = currentState.password,
                    password2 = currentState.confirmPassword
                )

                val result = authRepository.register(
                    request = registrationRequest
                ) as SuccessRegistrationResponseImpl
                Log.w("REGISTRATION", "SUCCESS: ${result.tokenType}")




            } catch(e: Exception) {
                Log.e("ERROR", e.toString())
            }
        }
    }


    private fun submitSignIn(): Any {
        TODO()
    }


}