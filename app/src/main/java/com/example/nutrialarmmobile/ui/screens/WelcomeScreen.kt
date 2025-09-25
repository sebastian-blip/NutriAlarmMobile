package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.NutriRed
import com.example.nutrialarmmobile.ui.theme.NutriBG
import com.example.nutrialarmmobile.ui.theme.NutriDarkBlue
import com.example.nutrialarmmobile.ui.theme.RobotoFontFamily

@Composable
fun WelcomeScreen(
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = NutriBG
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {

            Text(
                text = "Bienvenido",
                style = TextStyle(
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.72.sp, // 2% de 36sp
                    color = NutriDarkBlue,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Text(
                text = "a",
                style = TextStyle(
                    fontFamily = RobotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    lineHeight = 36.sp,
                    letterSpacing = 0.72.sp,
                    color = NutriDarkBlue,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 22.dp)
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(R.drawable.logo_nutrialarm),
                contentDescription = "Logo NutriAlarm",
                modifier = Modifier
                    .width(280.dp)
                    .height(120.dp)
                    .padding(bottom = 38.dp)
                    .align(Alignment.CenterHorizontally)
            )
            // Botón Registrarse más ancho
            Button(
                onClick = onRegisterClick,
                colors = ButtonDefaults.buttonColors(containerColor = NutriRed, contentColor = Color.White),
                shape = RoundedCornerShape(25.dp),
                modifier = Modifier
                    .width(220.dp)    // Aún más ancho que antes
                    .height(70.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    "Registrarse",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = RobotoFontFamily
                )
            }
            TextButton(
                onClick = onLoginClick,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp)
            ) {
                Text(
                    "Iniciar Sesión",
                    color = NutriDarkBlue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = RobotoFontFamily
                )
            }
        }
    }
}