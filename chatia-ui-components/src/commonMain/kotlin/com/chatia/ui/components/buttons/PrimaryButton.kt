package com.chatia.ui.components.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chatia.ui.components.texts.PrimaryText
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * A reusable button aligned with Material 3 and your design system.
 *
 * This button supports:
 * - Custom colors via [buttonColors].
 * - Custom text styling ([textColor], [textFontWeight], [textFontSize]).
 * - An optional leading [drawableResource] icon.
 * - Internal spacing control via [contentPadding].
 * - Optional elevation via [elevation] (if `null`, uses Material 3 defaults which are flat).
 * @param modifier Modifier to be applied to the button.
 * @param text Text to display inside the button.
 * @param onClick Lambda triggered when the button is clicked.
 * @param buttonColors Defines background & content colors. Defaults to [MaterialTheme.colorScheme.primary].
 * @param textColor Color of the button text. Defaults to white.
 * @param textFontWeight Font weight of the button text (e.g., [FontWeight.Normal], [FontWeight.Bold]).
 * @param textFontSize Font size of the button text. Defaults to `16.sp`.
 * @param drawableResource Optional drawable to display as a leading icon.
 * @param contentPadding Padding inside the button around its content. Defaults to [ButtonDefaults.ContentPadding].
 * @param elevation Optional shadow configuration. Pass a [ButtonElevation] (e.g., from [ButtonDefaults.buttonElevation])
 *                  to enable elevation. If `null`, the button uses Material's default flat style.
 */
@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
    ),
    textColor: Color = Color.White,
    textFontWeight: FontWeight,
    textFontSize: TextUnit = 16.sp,
    icon: (@Composable (() -> Unit))? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    elevation: ButtonElevation? = null
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = buttonColors,
        contentPadding = contentPadding,
        elevation = elevation
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            icon?.let {
                it()
            }
            PrimaryText(
                text = text,
                color = textColor,
                fontSize = textFontSize,
                fontWeight = textFontWeight
            )
        }
    }
}
