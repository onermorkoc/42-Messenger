package com.onermorkoc.messenger.view.pages

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onermorkoc.messenger.ui.theme._42MessengerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _42MessengerTheme {

                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "EditProfileScreen") {

                        composable("LoginScreen") { LoginScreen(navController) }
                        composable("HomeScreen") { HomeScreen(navController) }
                        composable("ContactsScreen") { ContactsScreen(navController) }
                        composable("EditProfileScreen") { EditProfileScreen() }
                    }
                }
            }
        }
    }
}