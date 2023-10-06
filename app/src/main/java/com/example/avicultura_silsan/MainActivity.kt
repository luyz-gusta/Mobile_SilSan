package com.example.avicultura_silsan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avicultura_silsan.screen.AnnouncementScreen
import com.example.avicultura_silsan.screen.CreateAccountScreen
import com.example.avicultura_silsan.screen.FeedScreen
import com.example.avicultura_silsan.screen.LoginScreen
import com.example.avicultura_silsan.screen.ProfileScreen
import com.example.avicultura_silsan.ui.theme.AviculturaSilsanTheme
import com.example.avicultura_silsan.view_model.AnuncioViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AviculturaSilsanTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(255,255,255)
                ) {

                    val navController = rememberNavController()
                    val anuncioViewModel = viewModel<AnuncioViewModel>()

                    NavHost(
                        navController = navController, startDestination = "profile"
                    ){

                        composable("login") {
                            LoginScreen(navController, lifecycleScope = lifecycleScope)
                        }

                        composable("create_account") {
                            CreateAccountScreen(navController = navController, lifecycleScope = lifecycleScope)
                        }

                        composable("feed") {
                            FeedScreen(navController = navController, viewModel = anuncioViewModel)
                        }

                        composable("anuncio") {
                            AnnouncementScreen()
                        }

                        composable("profile") {
                            ProfileScreen()
                        }

                    }
                }
            }
        }
    }
}
