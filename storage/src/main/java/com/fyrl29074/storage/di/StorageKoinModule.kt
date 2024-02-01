package com.fyrl29074.storage.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.fyrl29074.storage.dataSource.SharedPreferencesDataSource

val StorageKoinModule = module {
    factoryOf(::SharedPreferencesDataSource)
}