package com.example.harpia.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.harpia.navigation.HarpiaAppRouter
import com.example.harpia.navigation.Screen
import com.example.harpia.screens.AboutScreen
import com.example.harpia.screens.ExperienceResultScreen
import com.example.harpia.screens.HomeScreen
import com.example.harpia.screens.LoginScreen
import com.example.harpia.screens.MethodologiesScreen
import com.example.harpia.screens.NewExperienceScreen
import com.example.harpia.screens.PasswordScreen
import com.example.harpia.screens.ProfileScreen
import com.example.harpia.screens.SearchExperienceScreen
import com.example.harpia.screens.SignUpScreen
import com.example.harpia.screens.TeamScreen
import com.google.firebase.database.DatabaseReference

@Composable
fun HarpiaApp(databaseReference: DatabaseReference) {

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Crossfade(targetState = HarpiaAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is Screen.LoginScreen -> {
                    LoginScreen()
                }

                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.PasswordScreen -> {
                    PasswordScreen()
                }

                is Screen.AboutScreen -> {
                    AboutScreen()
                }

                is Screen.TeamScreen -> {
                    TeamScreen()
                }

                is Screen.HomeScreen -> {
                    HomeScreen()
                }

                is Screen.MethodologiesScreen -> {
                    MethodologiesScreen()
                }

                is Screen.ExperienceResultScreen -> {
                    ExperienceResultScreen()
                }

                is Screen.NewExperienceScreen -> {
                    NewExperienceScreen(databaseReference)
                }

                is Screen.ProfileScreen -> {
                    ProfileScreen()
                }

                is Screen.SearchExperienceScreen -> {
                    SearchExperienceScreen()
                }
            }
        }
    }
}