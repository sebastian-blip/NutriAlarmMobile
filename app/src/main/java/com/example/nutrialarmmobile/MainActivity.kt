package com.example.nutrialarmmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.*
import com.example.nutrialarmmobile.ui.screens.WelcomeScreen
import com.example.nutrialarmmobile.ui.screens.RegisterScreen
import com.example.nutrialarmmobile.ui.screens.AboutYouScreen
import com.example.nutrialarmmobile.ui.screens.HomeScreen
import com.example.nutrialarmmobile.ui.theme.NutriAlarmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriAlarmTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(
                            onRegisterClick = { navController.navigate("register") },
                            onLoginClick = { /* navega a login si tienes pantalla */ }
                        )
                    }
                    composable("register") {
                        RegisterScreen(
                            onContinueClick = { name, email, pass, confirmPass ->  navController.navigate("aboutyou")
                                // Aquí manejas el registro
                            }
                        )
                    }
                    composable("aboutyou") {
                        AboutYouScreen(
                            onContinueClick = { /* siguiente acción */ },
                            onOptionClick = { /* acción según opción */ },
                            onNoSelected = {
                                // Aquí ejecutas la navegación al Home
                                navController.navigate("home")
                            }
                        )
                    }

                    // Nueva ruta para HomeScreen
                    composable("home") {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
