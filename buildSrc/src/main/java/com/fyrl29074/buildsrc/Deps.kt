package com.fyrl29074.buildsrc

object Deps {
    object AndroidX {
        const val app_compat = "androidx.appcompat:appcompat:${Versions.AndroidX.app_compat_version}"
        const val core_ktx = "androidx.core:core-ktx:${Versions.AndroidX.android_core_version}"
        const val constraint_layout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraint_layout_version}"
    }

    object Koin {
        val koin_android = "io.insert-koin:koin-android:${Versions.Koin.koin_android_version}"
    }
}