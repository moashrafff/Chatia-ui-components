package com.chatia.ui.components.loading

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.github.moashrafff.chatia_ui_components.generated.resources.Res
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.PI
import kotlin.math.sin

/*
 * Copyright (c) 2025 Chatia, Team.
 *
 */
/**
 * Smooth, staggered ellipsis loader that lets you pass FOUR different PNGs—one per dot.
 *
 * @param dotResIds exactly four drawable IDs (left to right).
 * @param dotBaseSize the base layout size of each dot before scaling.
 * @param dotSpacing spacing between dots.
 * @param minScale smallest scale factor each dot reaches.
 * @param maxScale largest scale factor each dot reaches.
 * @param cycleDurationMs time for a full cycle (small→big→small).
 * @param travelRight if true, wave goes left→right; if false, right→left.
 */
@Composable
fun EllipsisLoaderMultiPng(
    dotResIds: List<String>,
    dotBaseSize: Dp = 14.dp,
    dotSpacing: Dp = 10.dp,
    minScale: Float = 0.6f,
    maxScale: Float = 1.4f,
    cycleDurationMs: Int = 900,
    travelRight: Boolean = true,
    modifier: Modifier = Modifier
) {
    require(dotResIds.size == 4) { "dotResIds must have exactly four drawables." }

    val dotCount = dotResIds.size
    val center = remember(minScale, maxScale) { (minScale + maxScale) / 2f }
    val amplitude = remember(minScale, maxScale) { (maxScale - minScale) / 2f }

    val transition = rememberInfiniteTransition(label = "ellipsis")
    val progress = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = cycleDurationMs, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "progress"
    ).value

    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(dotSpacing)) {
        dotResIds.forEachIndexed { index, resId ->
            val phase = if (travelRight) index.toFloat() / dotCount else (dotCount - 1 - index).toFloat() / dotCount
            val angle = 2f * PI.toFloat() * (progress + phase)
            val scale = center + amplitude * sin(angle)

            AsyncImage(
                model = Res.getUri("files/${resId}.svg"),
                contentDescription = "ellipsis-dot-$index",
                modifier = Modifier
                    .size(dotBaseSize)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        alpha = 0.85f + 0.15f * ((scale - minScale) / (maxScale - minScale))
                    }
            )
        }
    }
}

@Preview
@Composable
internal fun WaveLoadingPreview(){
    EllipsisLoaderMultiPng(
        dotResIds = listOf(
            "ellipsis_33",
            "ellipsis_34",
            "ellipsis_35",
            "ellipsis_36"
        ),
        dotBaseSize = 16.dp,
        dotSpacing = 12.dp,
        minScale = 0.55f,
        maxScale = 1.5f,
        cycleDurationMs = 850,
        travelRight = true
    )
}