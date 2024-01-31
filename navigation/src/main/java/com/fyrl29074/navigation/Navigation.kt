package com.fyrl29074.navigation

import androidx.fragment.app.Fragment

interface Navigation {
    fun navigateTo(fragment: Fragment, screen: NavScreens)
}