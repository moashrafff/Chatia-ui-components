package com.chatia.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = Color(0xFF6200EE),
    textColor: Color = Color.White,
    textFontWeight: FontWeight,
    textFontSize: TextUnit = 16.sp,
    fontFamily: FontFamily = FontFamily.Default,
    drawableResource: DrawableResource? =null
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            drawableResource?.let {
                Icon(
                    painter = painterResource(it),
                    contentDescription = null,
                )
            }
            Text(
                text = text,
                color = textColor,
                fontSize = textFontSize,
                fontWeight = textFontWeight,
                fontFamily = fontFamily
            )
        }

    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        modifier = Modifier.height(50.dp),
        text = "Sign In",
        onClick = {},
        backgroundColor = Color(0xFFE500AC),
        textFontWeight = FontWeight.Light,
    )
}