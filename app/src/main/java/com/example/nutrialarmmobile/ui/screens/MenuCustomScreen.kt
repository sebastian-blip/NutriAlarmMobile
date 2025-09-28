package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import com.example.nutrialarmmobile.ui.theme.BackgroundBlueCards
import com.example.nutrialarmmobile.ui.theme.BlueGeneralText
import com.example.nutrialarmmobile.ui.theme.NutriRed
import com.example.nutrialarmmobile.ui.theme.Typography

@Composable
fun MenuCustomScreen(
    onBack: () -> Unit,
    onCreateAlarm: () -> Unit,
    onOptionSelected: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // --- Parte fija ---
        HeaderSection(onBack = onBack)
        Spacer(modifier = Modifier.height(12.dp))
        QuestionSection()
        Spacer(modifier = Modifier.height(12.dp))
        OptionsSection(onOptionSelected = onOptionSelected)
        Spacer(modifier = Modifier.height(16.dp))

        // --- Parte scroll ---
        Column(
            modifier = Modifier
                .weight(1f) // ocupa el resto de la pantalla
                .verticalScroll(rememberScrollState())
        ) {
            DishDetectedSection()
            Spacer(modifier = Modifier.height(20.dp))
            InfoSection()
            Spacer(modifier = Modifier.height(60.dp))
        }

        BottomButtonSection(onCreateAlarm = onCreateAlarm)
    }
}

@Composable
fun HeaderSection(onBack: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp) //
    ) {
        Image(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "Atrás",
            modifier = Modifier
                .size(28.dp)
                .padding(start = 8.dp, top = 12.dp)
                .clickable { onBack() }
        )
        Text(
            text = "Crea tu plato",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun QuestionSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
         Image(
            painter = painterResource(R.drawable.ic_avatar),
            contentDescription = "Personaje",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .background(BlueGeneralText, RoundedCornerShape(12.dp))
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = "¿Quieres agregar un nuevo plato a tus alarmas?",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun OptionsSection(onOptionSelected: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        val cardModifier = Modifier
            .weight(1f)
            .height(100.dp)

        OptionCard(
            title = "Foto",
            imageRes = R.drawable.ic_camera,
            modifier = cardModifier,
            onClick = { onOptionSelected("foto") }
        )
        OptionCard(
            title = "Escribir",
            imageRes = R.drawable.ic_write,
            modifier = cardModifier,
            onClick = { onOptionSelected("escribir") }
        )
        OptionCard(
            title = "Hablar",
            imageRes = R.drawable.ic_microphone_blue,
            modifier = cardModifier,
            onClick = { onOptionSelected("hablar") }
        )
    }
}

@Composable
fun OptionCard(
    title: String,
    imageRes: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable { onClick() },
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor =  BackgroundBlueCards
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = title,
                modifier = Modifier.size(54.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                color = BlueGeneralText,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun DishDetectedSection() {
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
            .clip(RoundedCornerShape(16.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun InfoSection() {
    Column {
        Text("Ingredientes detectados", fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        RepeatCheckItems(3)

        Spacer(modifier = Modifier.height(12.dp))
        Text("Información nutricional", fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(4.dp))
        RepeatCheckItems(3)
    }
}

@Composable
fun RepeatCheckItems(count: Int) {
    repeat(count) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("✓", fontSize = 14.sp, modifier = Modifier.padding(end = 8.dp))
            Text("Ingrediente $it", fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

// Botón inferior
@Composable
fun BottomButtonSection(onCreateAlarm: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onCreateAlarm,
            colors = ButtonDefaults.buttonColors(NutriRed),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
                .wrapContentWidth()
                .height(56.dp)
        ) {
            Text(
                text = "Crear alarma para este plato",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
