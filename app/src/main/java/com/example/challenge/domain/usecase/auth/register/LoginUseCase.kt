package com.example.challenge.domain.usecase.auth.register

import com.example.challenge.data.local.entity.toUser
import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.User
import com.example.challenge.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(email: String, password: String): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val user = repository.login(email, password).toUser()
            emit(Resource.Success(user))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}