package com.onermorkoc.messenger.navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onermorkoc.messenger.view.pages.ContactsScreen
import com.onermorkoc.messenger.view.pages.EditProfileScreen
import com.onermorkoc.messenger.view.pages.HomeScreen
import com.onermorkoc.messenger.view.pages.LoginScreen

@Composable
fun NavGraph(activity: Activity, nightMode: () -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.LoginScreen.route){

        composable(Routes.LoginScreen.route) {
            LoginScreen(activity, nightMode = { nightMode() }){
                navController.navigate(it.route)
            }
        }

        composable(Routes.HomeScreen.route) {
            HomeScreen {
                navController.navigate(it.route)
            }
        }

        composable(Routes.ContactsScreen.route) {
            ContactsScreen {
                navController.navigate(it.route)
            }
        }

        composable(Routes.EditProfileScreen.route) {
            EditProfileScreen {
                navController.navigate(it.route)
            }
        }
    }
}