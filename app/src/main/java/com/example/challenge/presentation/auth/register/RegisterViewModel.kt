package com.example.challenge.presentation.auth.register

import android.graphics.Bitmap
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.User
import com.example.challenge.domain.usecase.auth.login.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val useCase: RegisterUseCase
) : ViewModel() {

    private var _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    fun register(username: String, email: String, password: String) {
        val user = User(
            username = username,
            email = email,
            password = password
        )
        useCase(user).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RegisterState(user = result.data)
                }
                is Resource.Error -> {
                    _state.value =
                        RegisterState(
                            error = result.message ?: "An unexpected error occured"
                        )
                }
                is Resource.Loading -> {
                    _state.value = RegisterState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}