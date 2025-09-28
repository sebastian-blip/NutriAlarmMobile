package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ChevronRight

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = BackgroundGlobal
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            HeaderSection()
            Spacer(modifier = Modifier.height(16.dp))
            NotifyRecommendation()
            Spacer(modifier = Modifier.height(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                CreaTuPlatoSection(navController)
                Spacer(modifier = Modifier.height(16.dp))
                ComidasProgramadasSection()
                Spacer(modifier = Modifier.height(16.dp))
                ActionsSection()
                Spacer(modifier = Modifier.height(16.dp))
                CrearAlarmaButton(navController)
            }
        }
    }
}


@Composable
fun HeaderSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = "Hola Juan !",
                style = Typography.titleLarge.copy(fontSize = 28.sp)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.logo_nutrialarm),
            contentDescription = "Logo de Nutrialarm",
            modifier = Modifier
                .height(40.dp)
        )
    }
}


@Composable
fun NotifyRecommendation() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Button(
            onClick = { /* Acción */ },
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(containerColor = BlueGeneralText),
            contentPadding = PaddingValues(horizontal = 18.dp, vertical = 12.dp)
        ) {
            Text(
                "Descubrir recomendación",
                color = White,
                style = Typography.titleLarge.copy(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Filled.ChevronRight,
                contentDescription = "Ir a recomendación",
                tint = NutriRed,
                modifier = Modifier.size(40.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        Image(
            painter = painterResource(R.drawable.ic_avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(20.dp))
        )
    }
}


@Composable
fun CreaTuPlatoSection(navController: NavController) {
    Text(
        text = "Crea tu plato",
        style = Typography.titleLarge
    )
    Spacer(modifier = Modifier.height(16.dp))
    Image(
        painter = painterResource(R.drawable.img_main_food),
        contentDescription = "Crea tu plato",
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {
                navController.navigate("menu")
            },
        contentScale = ContentScale.Crop
    )
}


@Composable
fun ComidasProgramadasSection() {
    Text(
        text = "Comidas programadas para hoy",
        style = Typography.titleLarge.copy(fontSize = 18.sp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    val comidas = listOf(
        R.drawable.img_food1,
        R.drawable.img_food2,
        R.drawable.img_food3,
        R.drawable.img_food4,
    )
    LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
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
        ActionCard(
            title = "Planes favoritos",
            iconRes = R.drawable.ic_favorite,
            backgroundColor = BackgroundBlueCards,
            modifier = Modifier.weight(1f),
        )
        ActionCard(
            title = "Preferencias",
            iconRes = R.drawable.ic_preferences,
            backgroundColor = BackgroundRedCards,
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
    Box(
        modifier = modifier
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(8.dp)
    ) {

        Text(
            text = title,
            fontFamily = RobotoFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = BlueGeneralText,
            modifier = Modifier.align(Alignment.BottomStart)
        )

        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(56.dp)
                .align(Alignment.CenterEnd)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun CrearAlarmaButton(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate("alarm") },
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = NutriRed)
        ) {
            Text(
                text = "Crear alarma",
                fontFamily = RobotoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(containerColor = BackgroundRedLightCards) {
        val items = listOf(
            BottomNavItem("Inicio", R.drawable.ic_home) { navController.navigate("home") },
            BottomNavItem("Recomendaciones", R.drawable.ic_recommendations) {  },
            BottomNavItem("Alarmas", R.drawable.ic_alarm) { navController.navigate("alarm") }
        )

        items.forEach { item ->
            NavigationBarItem(
                selected = false,
                onClick = { item.onClick() },
                alwaysShowLabel = true,
                icon = {
                    Image(
                        painter = painterResource(item.icon),
                        contentDescription = item.label,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.label, fontFamily = RobotoFontFamily) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}
data class BottomNavItem(
    val label: String,
    val icon: Int,
    val onClick: () -> Unit
)




