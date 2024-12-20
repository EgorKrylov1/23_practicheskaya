package com.example.a23practicheskaya

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.a23practicheskaya.screen.Analyzes
import com.example.a23practicheskaya.screen.MainScreen
import com.example.a23practicheskaya.screen.OnboardingScreen
import com.example.a23practicheskaya.screen.PatientRecord
import com.example.a23practicheskaya.screen.Registration
import com.example.a23practicheskaya.screen.Splash
import com.example.a23practicheskaya.screen.PasswordScreen
import com.example.a23practicheskaya.screen.Screenw
import androidx.navigation.NavHostController as NavHostController1

@Composable
fun Navigation(navController: NavHostController1) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            Splash(navController = navController)
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Registration.route) {
            Registration(navController = navController)
        }
        composable(route = Screen.Password.route) {
            PasswordScreen(navController = navController)
        }
        composable(route = Screen.PatientRecord.route) {
            PatientRecord(navController = navController)
        }
        composable(route = Screen.Analyzes.route) {
            Analyzes(navController = navController)
        }
        composable(route = Screen.Screenw.route) {
            Screenw(navController = navController)
        }
    }
}