package com.example.challenge.presentation.auth.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.usecase.auth.register.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCase: LoginUseCase
) : ViewModel() {

    private var _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun login(email: String, password: String) {
        useCase(email, password).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(user = result.data, result = true, error = "")
                }
                is Resource.Error -> {
                    _state.value = LoginState(error = "Akun tidak ditemukan")
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}