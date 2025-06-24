package com.example.zengarden.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zengarden.auth.domain.features.Resource
import com.example.zengarden.auth.domain.repository.AuthRepository
import com.example.zengarden.auth.domain.repository.SignInCredentials
import com.example.zengarden.auth.domain.repository.SignUpCredentials
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

        _state.value = (_state.value as AuthState.SignUpState).copy(
            isLoading = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            val credentials = SignUpCredentials(
                username = currentState.username,
                password = currentState.password,
                confirmPassword = currentState.confirmPassword
            )

            when(val result = authRepository.signUp(credentials = credentials)) {
                is Resource.Success -> {
                    Log.w("SIGN UP", "SUCCESS: ${result.data}")
                    _state.value = (_state.value as AuthState.SignUpState).copy(
                        error = null,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    Log.w("SIGN UP", "ERROR: CODE ${result.message}")
                    _state.value = (_state.value as AuthState.SignUpState).copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }
        }
    }


    private fun submitSignIn() {
        Log.w("AUTH_VIEWMODEL", "SIGN IN CALL START")
        val currentState = _state.value as AuthState.SignInState

        _state.value = (_state.value as AuthState.SignInState).copy(
            isLoading = true
        )

        viewModelScope.launch(Dispatchers.IO) {
            val credentials = SignInCredentials(
                username = currentState.username,
                password = currentState.password,
            )

            when(val result = authRepository.signIn(credentials = credentials)) {
                is Resource.Success -> {
                    Log.w("SIGN IN", "SUCCESS: ${result.data}")
                    _state.value = (_state.value as AuthState.SignInState).copy(
                        error = null,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    Log.w("SIGN IN", "ERROR: CODE ${result.message}")
                    _state.value = (_state.value as AuthState.SignInState).copy(
                        error = result.message,
                        isLoading = false
                    )
                }
            }
        }
        Log.w("AUTH_VIEWMODEL", "SIGN IN CALL END")
    }


}