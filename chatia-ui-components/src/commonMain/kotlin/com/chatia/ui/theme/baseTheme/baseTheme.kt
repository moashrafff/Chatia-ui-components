package com.chatia.ui.theme.baseTheme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.chatia.ui.theme.extendedColors.ExtendedColors
import io.github.moashrafff.chatia_ui_components.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.ExperimentalResourceApi
import androidx.compose.material3.Typography
import io.github.moashrafff.chatia_ui_components.generated.resources.sf_bold
import io.github.moashrafff.chatia_ui_components.generated.resources.sf_medium
import io.github.moashrafff.chatia_ui_components.generated.resources.sf_regular
import io.github.moashrafff.chatia_ui_components.generated.resources.sf_semibold


internal val lightExtendedColors =
    ExtendedColors(
        background = Color.White.copy(alpha = 0.62f),
        error = Color(0xFFEF5C5C),
        onError = Color.White,
        primary = Color(0xFFE500AC),
        errorLight = Color(0x1AEF5C5C),
        primaryLight = Color(0xFFFAF6F9),
        primaryLightBG = Color(0xFFDFF7FF),
        greyLight = Color(0xFFEDEDED),
        grey = Color(0xFF818898),
        greyMid = Color(0xFFA4ACB9),
        greyDark = Color(0xFF666D80),
        link = Color(0xFF0062FF),
        lightGreenBG1 = Color(0xFF58DF94),
        textPrimary = Color(0xFF0D0D12),
        yellowBG = Color(0xFFFFBE4C),
        verticalGradient = listOf(Color.White,Color(0xFFFFE5F9), Color(0xFFFFF7EB))
    )
@OptIn(ExperimentalResourceApi::class)
@Composable
fun mainFontFamily() = FontFamily(
    Font(Res.font.sf_regular, weight = FontWeight.Normal),
    Font(Res.font.sf_medium, weight = FontWeight.Medium),
    Font(Res.font.sf_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.sf_bold, weight = FontWeight.Bold)
)

@Composable
fun chatiaTypography() = Typography().run {

    val fontFamily = mainFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}


val LocalAppColors = staticCompositionLocalOf { lightExtendedColors }

private fun buildColorScheme(extended: ExtendedColors, darkTheme: Boolean): ColorScheme {
    return if (darkTheme) {
        darkColorScheme(
            primary = extended.primary,
            background = extended.background,
            error = extended.error,
            onError = extended.onError,
            onSurface = extended.textPrimary,
            onSurfaceVariant = extended.greyMid,
            secondary = extended.grey,
            onSecondary = extended.greyDark
        )
    } else {
        lightColorScheme(
            primary = extended.primary,
            background = extended.background,
            error = extended.error,
            onError = extended.onError,
            onSurface = extended.textPrimary,
            onSurfaceVariant = extended.greyMid,
            secondary = extended.grey,
            onSecondary = extended.greyDark
        )
    }
}


@Composable
fun ChatiaTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val extended = lightExtendedColors
    val colorScheme = buildColorScheme(extended, darkTheme)
    CompositionLocalProvider(LocalAppColors provides extended) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = chatiaTypography(),
            content = content,
        )
    }
}