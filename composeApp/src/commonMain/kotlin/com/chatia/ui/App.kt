package com.chatia.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.chatia.ui.components.inputFields.PrimaryInputField
import com.chatia.ui.theme.baseTheme.ChatiaTheme

@Composable
fun App() {
    ChatiaTheme {
        var value by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            PrimaryInputField(
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                shape = RoundedCornerShape(48.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White.copy(alpha = .5F),
                    unfocusedContainerColor = Color.White.copy(alpha = .5F),
                    disabledContainerColor = Color.White.copy(alpha = .5F),
                    errorContainerColor = Color.White.copy(alpha = .5F),
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = Color.White,
                    disabledIndicatorColor = Color.White.copy(alpha = 0.5f),
                    errorIndicatorColor = Color.White
                ),
                placeholder = "username",
                value = value,
                onValueChange = { value = it },
                isError = true,
                errorText = "incorrect_password",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
    }
}
