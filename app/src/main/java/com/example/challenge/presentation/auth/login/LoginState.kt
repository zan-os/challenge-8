package com.example.challenge.presentation.auth.login

import com.example.challenge.domain.model.User

data class LoginState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = "",
    val result: Boolean = false
)