package com.chatia.ui.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * A reusable card with optional elevation, shape, stroke (border), colors, and click handling.
 *
 * - If [onClick] is `null`, renders a non-clickable Card.
 * - If [onClick] is provided, uses the clickable Card overload with ripple and proper semantics.
 *
 * @param modifier Modifier to be applied to the card.
 * @param withElevation If true, apply [elevation]; if false, no shadow.
 * @param elevation The base shadow elevation when [withElevation] is true.
 * @param cardColors Card colors (background/content). Defaults to [CardDefaults.cardColors].
 * @param shape The shape of the card. Defaults to [MaterialTheme.shapes.medium].
 * @param borderWidth Width of the stroke (border). Defaults to `0.dp` (no border).
 * @param borderColor Color of the stroke (supports alpha). Defaults to `Color.Transparent`.
 * @param enabled Whether the card is enabled when clickable.
 * @param onClick Optional click handler. If null → non-clickable card.
 * @param content The content of the card.
 */
@Composable
fun PrimaryCard(
    modifier: Modifier = Modifier,
    withElevation: Boolean = true,
    elevation: Dp = 1.dp,
    cardColors: CardColors = CardDefaults.cardColors(),
    shape: Shape = MaterialTheme.shapes.medium,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Transparent,
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit
) {
    val cardElevation = if (withElevation) {
        CardDefaults.cardElevation(
            defaultElevation = elevation,
            pressedElevation = elevation * 2,
            focusedElevation = elevation,
            hoveredElevation = elevation + 1.dp,
            draggedElevation = elevation + 2.dp,
            disabledElevation = 0.dp
        )
    } else {
        CardDefaults.cardElevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
    }

    val cardBorder = if (borderWidth > 0.dp) {
        BorderStroke(borderWidth, borderColor)
    } else null

    if (onClick == null) {
        Card(
            modifier = modifier,
            elevation = cardElevation,
            colors = cardColors,
            shape = shape,
            border = cardBorder,
            content = { content() }
        )
    } else {
        Card(
            modifier = modifier,
            onClick = onClick,
            enabled = enabled,
            elevation = cardElevation,
            colors = cardColors,
            shape = shape,
            border = cardBorder,
            content = { content() }
        )
    }
}