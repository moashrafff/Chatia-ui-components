package com.chatia.ui.components

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.chatia.ui.theme.baseTheme.lightExtendedColors

/*
 * Copyright (c) 2025 Chatia, Team.
 *
 */

/**
 * Applies a vertical linear gradient background to the current [Modifier].
 *
 * The gradient spans from the **top** (0f) to the **bottom** (1f) of the composable’s height,
 * and interpolates between the provided [stops].
 *
 * Each stop is defined as a `Pair<Float, Color>`:
 * - The [Float] is a fraction of the height in the range `0f..1f`
 *   (`0f` = top, `1f` = bottom).
 * - The [Color] is the color applied at that position.
 *
 * @param stops Gradient color stops as fraction–color pairs.
 * @return A [Modifier] with the vertical gradient applied as a background.
 */
fun Modifier.verticalGradientStops(
    vararg stops: Pair<Float, Color> = arrayOf(
        0.12f to lightExtendedColors.verticalGradient.first(),
        0.24f to lightExtendedColors.verticalGradient[1],
        0.66f to lightExtendedColors.verticalGradient.last()
    )
): Modifier = drawBehind {
    val brush = Brush.linearGradient(
        *stops,
        start = Offset(0f, 0f),
        end = Offset(0f, size.height)
    )
    drawRect(brush = brush)
}