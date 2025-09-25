package com.example.nutrialarmmobile.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(
    primary = NutriRed,
    onPrimary = White,
    secondary = NutriBlue,
    onSecondary = NutriDarkBlue,
    background = NutriBG,
    surface = White,
    onBackground = NutriDarkBlue,
    onSurface = NutriGray
)

private val DarkColors = darkColorScheme(
    primary = NutriRed,
    onPrimary = White,
    secondary = NutriBlue,
    onSecondary = NutriGray,
    background = NutriDarkBlue,
    surface = NutriGray,
    onBackground = NutriBG,
    onSurface = White
)

@Composable
fun NutriAlarmTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography, // puedes personalizar Typography si quieres
        shapes = Shapes,         // puedes personalizar Shapes si quieres
        content = content
    )
}