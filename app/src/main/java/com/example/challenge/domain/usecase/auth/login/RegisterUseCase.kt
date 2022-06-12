package com.example.challenge.domain.usecase.auth.login

import com.example.challenge.data.resource.Resource
import com.example.challenge.domain.model.User
import com.example.challenge.domain.model.toUserEntity
import com.example.challenge.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    operator fun invoke(user: User): Flow<Resource<Long>> = flow {
        try {
            emit(Resource.Loading())
            val userEntity = user.toUserEntity()
            val data = repository.register(userEntity)
            emit(Resource.Success(data))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
    }
}