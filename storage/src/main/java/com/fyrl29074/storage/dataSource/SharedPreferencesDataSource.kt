package com.fyrl29074.storage.dataSource

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesDataSource(
    context: Context
) {
    private val storage: SharedPreferences =
        context.getSharedPreferences("storage", Context.MODE_PRIVATE)

    fun saveName(name: String) {
        save(NAME, name)
    }

    fun saveSurname(surname: String) {
        save(SURNAME, surname)
    }

    fun savePhone(phone: String) {
        save(PHONE, phone)
    }

    fun getName(): String? {
        return get(NAME)
    }

    fun getSurname(): String? {
        return get(SURNAME)
    }

    fun getPhone(): String? {
        return get(PHONE)
    }

    private fun save(key: String, value: String) {
        storage.edit().putString(key, value).apply()
    }

    private fun get(key: String): String? {
        return storage.getString(key, null)
    }

    companion object {
        const val NAME = "name"
        const val SURNAME = "surname"
        const val PHONE = "phone"
    }
}