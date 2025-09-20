package com.chatia.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.chatia.ui.components.buttons.PrimaryButton
import com.chatia.ui.theme.baseTheme.ChatiaTheme

@Composable
fun App() {
    ChatiaTheme {
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            PrimaryButton(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                text = "Sign In",
                onClick = {},
                textFontWeight = FontWeight.Medium,
            )
        }
    }
}