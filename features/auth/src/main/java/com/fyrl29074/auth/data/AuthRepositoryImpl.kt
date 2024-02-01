package com.fyrl29074.auth.data

import com.fyrl29074.auth.domain.repository.AuthRepository
import com.fyrl29074.storage.dataSource.SharedPreferencesDataSource
import kotlinx.coroutines.delay

class AuthRepositoryImpl(
    private val sharedPreferencesDataSource: SharedPreferencesDataSource
): AuthRepository {
    override suspend fun auth(name: String, surname: String, phone: String) {

        // fake success auth api call
        delay(5000)

        sharedPreferencesDataSource.saveName(name)
        sharedPreferencesDataSource.saveSurname(surname)
        sharedPreferencesDataSource.savePhone(phone)
    }
}