package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.NutriBG
import com.example.nutrialarmmobile.ui.theme.NutriBlue
import com.example.nutrialarmmobile.ui.theme.NutriDarkBlue
import com.example.nutrialarmmobile.ui.theme.NutriBlueAccent
import com.example.nutrialarmmobile.ui.theme.RobotoFontFamily

@Composable
fun RegisterScreen(
    onContinueClick: (name: String, email: String, password: String, confirmPassword: String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = NutriBG
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 50.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo_negro),
                contentDescription = "Logo NutriAlarm",
                modifier = Modifier
                    .width(220.dp)
                    .height(120.dp)
                    .padding(bottom = 24.dp)
            )
            // Nombre
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Nombre", fontFamily = RobotoFontFamily, color = NutriDarkBlue) },
                placeholder = { Text("Nombre", color = Color.Gray, fontFamily = RobotoFontFamily) },
                singleLine = true,
                shape = RoundedCornerShape(5.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = NutriBlue,
                    focusedContainerColor = NutriBlue,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            )
            Text(
                text = "Nombre",
                fontSize = 20.sp,
                fontFamily = RobotoFontFamily,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 6.dp) // <-- margen izquierdo igual al campo
            )
            // Correo
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Correo", fontFamily = RobotoFontFamily, color = NutriDarkBlue) },
                placeholder = { Text("Name@gmail.com", color = Color.Gray, fontFamily = RobotoFontFamily) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = NutriBlue,
                    focusedContainerColor = NutriBlue,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            )
            Text(
                text = "Correo",
                fontSize = 20.sp,
                fontFamily = RobotoFontFamily,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 6.dp) // <-- margen izquierdo igual al campo
            )
            // Contraseña
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña", fontFamily = RobotoFontFamily, color = NutriDarkBlue) },
                placeholder = { Text("******", color = Color.Gray, fontFamily = RobotoFontFamily) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = NutriBlue,
                    focusedContainerColor = NutriBlue,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            )
            Text(
                text = "Contraseña",
                fontSize = 20.sp,
                fontFamily = RobotoFontFamily,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 6.dp) // <-- margen izquierdo igual al campo
            )
            // Confirmar contraseña
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = { Text("Confirmar Contraseña", fontFamily = RobotoFontFamily, color = NutriDarkBlue) },
                placeholder = { Text("******", color = Color.Gray, fontFamily = RobotoFontFamily) },
                singleLine = true,
                shape = RoundedCornerShape(8.dp),
                visualTransformation = PasswordVisualTransformation(),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = NutriBlue,
                    focusedContainerColor = NutriBlue,
                    unfocusedBorderColor = Color.Transparent,
                    focusedBorderColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            )
            Text(
                text = "Confirmar Contraseña",
                fontSize = 20.sp,
                fontFamily = RobotoFontFamily,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = 16.dp, bottom = 6.dp) // <-- margen izquierdo igual al campo
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Botón continuar
            Button(
                onClick = { onContinueClick(name, email, password, confirmPassword) },
                colors = ButtonDefaults.buttonColors(containerColor = NutriBlueAccent, contentColor = Color.White),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .width(220.dp)
                    .height(70.dp)
                    .padding(top = 24.dp)
            ) {
                Text(
                    "Continuar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = RobotoFontFamily,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}