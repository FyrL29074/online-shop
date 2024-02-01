package com.fyrl29074.auth.di

import com.fyrl29074.auth.domain.AuthUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.fyrl29074.auth.presentation.AuthViewModel
import org.koin.core.module.dsl.factoryOf
import com.fyrl29074.auth.domain.AuthUseCaseImpl
import com.fyrl29074.auth.domain.repository.AuthRepository
import com.fyrl29074.auth.data.AuthRepositoryImpl
import org.koin.dsl.bind

val AuthFeatureKoinModule = module {
    viewModelOf(::AuthViewModel)
    factoryOf(::AuthUseCaseImpl) bind AuthUseCase::class
    factoryOf(::AuthRepositoryImpl) bind AuthRepository::class
}