package com.example.nutrialarmmobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.nutrialarmmobile.R
import com.example.nutrialarmmobile.ui.theme.BlueGeneralText
import com.example.nutrialarmmobile.ui.theme.NutriBlueAccent
import com.example.nutrialarmmobile.ui.theme.NutriRed
import com.example.nutrialarmmobile.ui.theme.White
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.nutrialarmmobile.ui.theme.BackgroundBlueCards
import com.example.nutrialarmmobile.ui.theme.BackgroundGlobal
import com.example.nutrialarmmobile.ui.theme.BackgroundRedCards


@Composable
fun AlarmScreen(navController: NavController) {
    var note by remember { mutableStateOf("")}

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) },
        containerColor = BackgroundGlobal
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // --- Parte fija ---
            AlarmHeader()
            Spacer(modifier = Modifier.height(16.dp))
            AlarmNoteInput(
                note = note,
                onNoteChange = { note = it },
                onClear = { note = "" }
            )
            Spacer(modifier = Modifier.height(16.dp))

            // --- Parte scroll ---
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
            ) {
                DateTimeSelectionCard()
                Spacer(modifier = Modifier.height(16.dp))
                SaveAlarmButton()
                Spacer(modifier = Modifier.height(24.dp))
                CreatedAlarmsSection()
                Spacer(modifier = Modifier.height(24.dp))
                ProgressSection()
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}


@Composable
fun AlarmHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
    ) {
        // Imagen en lugar de Icon
        Image(
            painter = painterResource(id = R.drawable.ic_alarm),
            contentDescription = "Alarma",
            modifier = Modifier.size(56.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = "Registro de alarmas",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}



@Composable
fun AlarmNoteInput(
    note: String,
    onNoteChange: (String) -> Unit,
    onClear: () -> Unit
) {
    Column {
        Text(
            text = "Nota alarma",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .background(BackgroundBlueCards, RoundedCornerShape(8.dp))
                .padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            BasicTextField(
                value = note,
                onValueChange = onNoteChange,
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp
                ),
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    if (note.isEmpty()) {
                        Text("Recordar ...", color = Color.Gray, fontSize = 14.sp)
                    }
                    innerTextField()
                }
            )

            if (note.isNotEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = "Limpiar",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onClear() }
                )
            }
        }
    }
}

@Composable
fun DateTimeSelectionCard() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.75f),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = BlueGeneralText)
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Título más pequeño
                Text(
                    "Selecciona fecha y hora",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Hora y AM/PM
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    // Cuadro hora
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(width = 48.dp, height = 48.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(NutriBlueAccent),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("20", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text("Hora", color = Color.White, fontSize = 12.sp)
                    }

                    // Cuadro minutos
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Box(
                            modifier = Modifier
                                .size(width = 48.dp, height = 48.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(Color.White),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("00", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
                        }
                        Spacer(modifier = Modifier.height(2.dp))
                        Text("Minutos", color = Color.White, fontSize = 12.sp)
                    }

                    // AM / PM
                    Column {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = NutriBlueAccent)
                        ) { Text("AM", fontSize = 12.sp) }

                        Spacer(modifier = Modifier.height(2.dp))

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(6.dp),
                            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                        ) { Text("PM", fontSize = 12.sp, color = Color.Black) }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("dd/mm/yyyy", color = White, fontSize = 14.sp) },
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = LocalTextStyle.current.copy(fontSize = 14.sp)
                )
            }
        }
    }
}

@Composable
fun SaveAlarmButton() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { /* Guardar alarma */ },
            modifier = Modifier
                .width(220.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = NutriRed),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text(
                text = "Guardar alarma",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun CreatedAlarmsSection() {
    Text("Alarmas creadas", fontWeight = FontWeight.Bold, fontSize = 24.sp)
    Spacer(modifier = Modifier.height(8.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hace una semana",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(BackgroundBlueCards),
                contentAlignment = Alignment.Center
            ) {
                Text("", fontSize = 22.sp)
            }
        }

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Hace un mes",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(BackgroundRedCards),
                contentAlignment = Alignment.Center
            ) {
                Text("", fontSize = 22.sp)
            }
        }
    }
}


@Composable
fun ProgressSection() {
    Text(
        text = "Avances",
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    )
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        ActionCard(
            title = "Estadísticas",
            iconRes = R.drawable.ic_statistics,
            backgroundColor = BackgroundBlueCards,
            modifier = Modifier
                .weight(1f)
                .height(120.dp)
        )
        ActionCard(
            title = "Progreso",
            iconRes = R.drawable.ic_progress,
            backgroundColor = BackgroundRedCards,
            modifier = Modifier
                .weight(1f)
                .height(120.dp)
        )
    }
}


