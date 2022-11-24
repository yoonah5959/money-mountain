package heenu.moon.moneymountain.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = Yellow300,
    onPrimary = White,
    secondary = Gray8,
    onSecondary = Gray3,
    surface = Gray9,
    onSurface = White,
    background = Gray9,
    onBackground = White
)

private val LightColorPalette = lightColors(
    primary = Yellow300,
    onPrimary = Gray9,
    secondary = Gray7,
    onSecondary = Gray9,
    surface = White,
    onSurface = Gray9,
    background = White,
    onBackground = Gray9
)

@Composable
fun MoneyMountainTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(
        color = colors.background
    )
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

