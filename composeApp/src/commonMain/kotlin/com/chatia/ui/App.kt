package com.chatia.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chatia.ui.components.loading.EllipsisLoaderMultiPng
import com.chatia.ui.theme.baseTheme.ChatiaTheme

@Composable
fun App() {
    ChatiaTheme {
        Box(
            modifier = Modifier
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            EllipsisLoaderMultiPng(
                modifier = Modifier.align(Alignment.Center),
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
                travelRight = true // set false to make the wave go right→left
            )
        }
    }
}