package com.chatia.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.chatia.ui.components.inputFields.PrimaryInputField
import com.chatia.ui.components.verticalGradientStops
import com.chatia.ui.theme.baseTheme.ChatiaTheme

@Composable
fun App() {
    ChatiaTheme {
        var value by remember { mutableStateOf("") }
        Box(
            modifier = Modifier
                .verticalGradientStops()
//                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
        ) {
            PrimaryInputField(
                modifier = Modifier.fillMaxWidth().padding(0.dp),
                shape = RoundedCornerShape(48.dp),
                placeholder = "username",
                value = value,
                onValueChange = { value = it },
                isError = false,
                errorText = "incorrect_password",
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
        }
    }
}
