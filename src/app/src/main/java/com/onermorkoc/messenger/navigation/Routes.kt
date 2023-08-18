package com.onermorkoc.messenger.navigation

sealed class Routes(val route: String) {
    object LoginScreen: Routes("login_screen")
    object HomeScreen: Routes("home_screen")
    object ContactsScreen: Routes("contacts_screen")
    object EditProfileScreen: Routes("edit_profile_screen")
}