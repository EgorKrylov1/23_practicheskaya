package com.example.a23practicheskaya

sealed class Screen(val route: String) {
    object Splash : Screen("Splash")
    object Onboarding : Screen("Onboarding")
    object MainScreen : Screen("MainScreen")
    object Registration : Screen("Registration")
    object PatientRecord : Screen("PatientRecord")
    object Password : Screen("Password")
    object Analyzes : Screen("Analyzes")
    object Screenw : Screen("Screenw")
}