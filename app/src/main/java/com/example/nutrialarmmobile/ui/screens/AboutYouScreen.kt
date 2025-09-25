package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.NutriBG
import com.example.nutrialarmmobile.ui.theme.NutriBlueAccent
import com.example.nutrialarmmobile.ui.theme.RobotoFontFamily
import com.example.nutrialarmmobile.ui.theme.NutriBlue
import com.example.nutrialarmmobile.ui.theme.NutriRed
import com.example.nutrialarmmobile.ui.theme.NutriDarkBlue
import com.example.nutrialarmmobile.ui.theme.White

@Composable
fun AboutYouScreen(
    onContinueClick: () -> Unit,
    onOptionClick: (option: String) -> Unit
) {
    var showModal by remember { mutableStateOf(false) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = NutriBG
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Cuéntanos de ti",
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Elige cómo contarnos sobre tus hábitos alimenticios",
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(24.dp))
            // Imagen principal (manzana + corazón)
            Image(
                painter = painterResource(R.drawable.ic_apple_heart),
                contentDescription = "Salud y alimentación",
                modifier = Modifier
                    .size(300.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            // Opciones
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OptionIcon(
                    icon = R.drawable.ic_microphone_blue,
                    label = "Hablar",
                    onClick = { onOptionClick("Hablar") }
                )
                OptionIcon(
                    icon = R.drawable.ic_camera,
                    label = "Foto",
                    onClick = { onOptionClick("Foto") }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                OptionIcon(
                    icon = R.drawable.ic_write,
                    label = "Escribir",
                    onClick = { onOptionClick("Escribir") }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { showModal = true },
                colors = ButtonDefaults.buttonColors(
                    containerColor = NutriBlueAccent,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier
                    .width(220.dp)
                    .height(50.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    "Continuar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = RobotoFontFamily,
                    textAlign = TextAlign.Center
                )
            }

            NutriAlertDialog(
                show = showModal,
                onDismiss = { showModal = false },
                onYes = { /* Acción para Sí */ showModal = false },
                onNo = { /* Acción para No */ showModal = false }
            )
        }
    }
}

// Composable para cada opción
@Composable
fun OptionIcon(
    icon: Int,
    label: String,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(6.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = NutriBlue,
            modifier = Modifier
                .width(70.dp)   // Más ancho
                .height(90.dp),
            onClick = onClick
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(icon),
                    contentDescription = label,
                    modifier = Modifier.size(60.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = label,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun NutriAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onYes: () -> Unit,
    onNo: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                Button(
                    onClick = onYes,
                    colors = ButtonDefaults.buttonColors(containerColor = NutriRed), // Rojo
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("Si", color = White)
                }
            },
            dismissButton = {
                Button(
                    onClick = onNo,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    shape = RoundedCornerShape(24.dp)
                ) {
                    Text("No", color = White)
                }
            },
            title = {
                Text(
                    text = "Tenemos tu información nutricional básica",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            },
            text = {
                Text(
                    text = "¿Deseas agregar algo más antes de continuar?",
                    color = White,
                    fontSize = 16.sp
                )
            },
            containerColor = NutriDarkBlue, // Azul muy oscuro
            shape = RoundedCornerShape(32.dp),
        )
    }
}
