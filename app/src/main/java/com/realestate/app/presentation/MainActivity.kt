package com.realestate.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.realestate.app.navigation.RealEstateNavScreen
import com.realestate.app.presentation.home.HomeScreen
import com.realestate.app.ui.theme.SMGRealEstateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SMGRealEstateTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = RealEstateNavScreen.HomeNavScreen.route
                ) {
                    composable(route = RealEstateNavScreen.HomeNavScreen.route) { HomeScreen() }
                }
            }
        }
    }
}
