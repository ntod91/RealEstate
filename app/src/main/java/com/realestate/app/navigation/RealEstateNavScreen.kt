package com.realestate.app.navigation

sealed class RealEstateNavScreen(val route: String) {
    object HomeNavScreen : RealEstateNavScreen("HomeScreen")
}
