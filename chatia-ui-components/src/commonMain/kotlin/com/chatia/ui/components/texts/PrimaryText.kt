package com.chatia.ui.components.texts

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit


/**
 * Primary reusable text component for displaying primary text in the app.
 *
 * Parameters:
 * @param text The text to display.
 * @param modifier Modifier to adjust layout or behavior.
 * @param style Base text style. Defaults to [MaterialTheme.typography.bodyLarge].
 * @param color Text color. Defaults to [MaterialTheme.colorScheme.onSurface].
 * @param fontSize Font size override. Leave [TextUnit.Unspecified] to use [style.fontSize].
 * @param fontWeight Font weight override. Leave null to use [style.fontWeight].
 * @param fontStyle Font style override (e.g., italic). Leave null to use [style.fontStyle].
 * @param textAlign Horizontal alignment (start, center, end, justify). Leave null to use [style.textAlign].
 * @param textDecoration Decorations such as underline or strikethrough. Leave null for none.
 * @param letterSpacing Space between characters. Leave [TextUnit.Unspecified] to use [style.letterSpacing].
 * @param lineHeight Line height override. Leave [TextUnit.Unspecified] to use [style.lineHeight].
 * @param maxLines Maximum number of lines before truncation. Defaults to unlimited.
 * @param softWrap Whether the text should break at soft line breaks. Defaults to true.
 * @param overflow How visual overflow should be handled (clip, ellipsis, etc.).
 */
@Composable
fun PrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = MaterialTheme.colorScheme.onSurface,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight? = null,
    fontStyle: FontStyle? = null,
    textAlign: TextAlign? = null,
    textDecoration: TextDecoration? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
    softWrap: Boolean = true,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        softWrap = softWrap,
        maxLines = maxLines,
        overflow = overflow,
        style = style.copy(

            fontSize = if (fontSize != TextUnit.Unspecified) fontSize else style.fontSize,
            fontWeight = fontWeight ?: style.fontWeight,
            fontStyle = fontStyle ?: style.fontStyle,
            textAlign = textAlign ?: style.textAlign,
            textDecoration = textDecoration ?: style.textDecoration,
            letterSpacing = if (letterSpacing != TextUnit.Unspecified) letterSpacing else style.letterSpacing,
            lineHeight = if (lineHeight != TextUnit.Unspecified) lineHeight else style.lineHeight,
        )
    )
}