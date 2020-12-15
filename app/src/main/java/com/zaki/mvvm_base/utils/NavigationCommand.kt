package com.zaki.mvvm_base.utils

import androidx.navigation.NavDirections

sealed class NavigationCommand(val id: Int = 0) {
    data class To(val directions: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
    data class BackTo(val destinationId: Int) : NavigationCommand()
    object ToRoot : NavigationCommand()
}