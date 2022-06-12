package com.example.challenge.presentation.auth.register

data class RegisterState(
    val isLoading: Boolean = false,
    val user: Long? = null,
    val error: String = ""
)
