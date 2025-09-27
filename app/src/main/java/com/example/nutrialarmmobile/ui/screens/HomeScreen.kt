package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.RobotoFontFamily

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() },
        containerColor = Color(0xFFFFFAFA)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(16.dp))
            CreaTuPlatoSection()
            Spacer(modifier = Modifier.height(16.dp))
            ComidasProgramadasSection()
            Spacer(modifier = Modifier.height(16.dp))
            ActionsSection()
            Spacer(modifier = Modifier.height(16.dp))
            CrearAlarmaButton()
        }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Hola Juan !",
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { /* Acción */ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF123456))
            ) {
                Text("Descubrir recomendación", color = Color.White)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_recommendations),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(R.drawable.ic_avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}

@Composable
fun CreaTuPlatoSection() {
    Text(
        text = "Crea tu plato",
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    Image(
        painter = painterResource(R.drawable.img_main_food),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ComidasProgramadasSection() {
    Text(
        text = "Comidas programadas para hoy",
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    val comidas = listOf(
        R.drawable.img_food1,
        R.drawable.img_food2,
        R.drawable.img_food3
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(comidas) { comida ->
            Image(
                painter = painterResource(comida),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun ActionsSection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Cada ActionCard ocupa el mismo espacio dentro del Row
        ActionCard(
            title = "Planes favoritos",
            iconRes = R.drawable.ic_favorite,
            backgroundColor = Color(0xFFD6E8FF),
            modifier = Modifier.weight(1f)
        )
        ActionCard(
            title = "Preferencias",
            iconRes = R.drawable.ic_preferences,
            backgroundColor = Color(0xFFFFD6D6),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun ActionCard(
    title: String,
    iconRes: Int,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable { /* Acción */ }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}

@Composable
fun CrearAlarmaButton() {
    Button(
        onClick = { /* Acción */ },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
    ) {
        Text(
            text = "Crear alarma",
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(
            selected = true,
            onClick = { /* Acción */ },
            icon = { Icon(painterResource(R.drawable.ic_home), contentDescription = null) },
            label = { Text("Inicio") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Acción */ },
            icon = { Icon(painterResource(R.drawable.ic_recommendations), contentDescription = null) },
            label = { Text("Recomendaciones") }
        )
        NavigationBarItem(
            selected = false,
            onClick = { /* Acción */ },
            icon = { Icon(painterResource(R.drawable.ic_alarm), contentDescription = null) },
            label = { Text("Alarmas") }
        )
    }
}
