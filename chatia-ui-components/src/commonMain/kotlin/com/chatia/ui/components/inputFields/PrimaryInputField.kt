package com.chatia.ui.components.inputFields

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.chatia.ui.components.texts.PrimaryText
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * Outlined input field aligned with Material 3 and your theme.
 *
 * Parameters:
 * @param value Current text value.
 * @param onValueChange Callback when the text changes.
 * @param modifier Layout modifier.
 * @param label Optional floating label text.
 * @param placeholder Optional placeholder text (shown when empty & not focused).
 * @param leadingIcon Optional leading icon composable.
 * @param trailingIcon Optional trailing icon composable.
 * @param helperText Optional supporting text below the field (used when not error).
 * @param errorText Optional error text below the field (takes precedence over helperText when [isError] is true).
 * @param isError Whether to show error state.
 * @param singleLine Whether the field is single line.
 * @param maxLines Maximum lines (ignored if singleLine = true).
 * @param enabled Whether the field is enabled.
 * @param readOnly Whether the field is read-only.
 * @param keyboardOptions IME keyboard options.
 * @param keyboardActions IME keyboard actions.
 * @param visualTransformation Text transformation (e.g., [PasswordVisualTransformation]).
 * @param colors Custom colors. Defaults follow your theme (onSurface, onSurfaceVariant, primary, error, etc.).
 * @param textStyle Optional override for text style. Defaults to [MaterialTheme.typography.bodyLarge].
 * @param shape Field shape. Defaults to [MaterialTheme.shapes.small].
 */

@Preview
@Composable
fun PrimaryInputField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String? = null,
    placeholder: String? = null,
    placeholderColor: Color = Color.Unspecified,
    labelColor: Color = Color.Unspecified,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    helperText: String? = null,
    errorText: String? = null,
    isError: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    colors:TextFieldColors = TextFieldDefaults.colors(
        //CONTAINER
        focusedContainerColor = Color.White.copy(alpha = .5F),
        unfocusedContainerColor = Color.White.copy(alpha = .5F),
        disabledContainerColor = Color.White.copy(alpha = .5F),
        errorContainerColor = Color.White.copy(alpha = .5F),

        //INDICATOR
        focusedIndicatorColor = MaterialTheme.colorScheme.primary,
        unfocusedIndicatorColor = Color.White,
        disabledIndicatorColor = Color.White.copy(alpha = 0.5f),
        errorIndicatorColor = Color.White,

        //TEXT
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        errorTextColor = MaterialTheme.colorScheme.onSurface,

        //CURSOR
        cursorColor = MaterialTheme.colorScheme.primary,
        errorCursorColor = MaterialTheme.colorScheme.error,

        //LABEL
        focusedLabelColor = MaterialTheme.colorScheme.primary,
        unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
        disabledLabelColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
        errorLabelColor = MaterialTheme.colorScheme.error,

        //PLACEHOLDER
        focusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,
        errorPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant,

        //LEADING ICON
        focusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedLeadingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        focusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        unfocusedTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        errorTrailingIconColor = MaterialTheme.colorScheme.error,

    ),
    textStyle: androidx.compose.ui.text.TextStyle = MaterialTheme.typography.bodyLarge,
    shape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(48.dp)
) {
    val message = when {
        isError && !errorText.isNullOrBlank() -> errorText
        !helperText.isNullOrBlank() -> helperText
        else -> null
    }
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = singleLine,
        maxLines = maxLines,
        enabled = enabled,
        readOnly = readOnly,
        isError = isError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        textStyle = textStyle,
        shape = shape,
        label = label?.let {
            {
                PrimaryText(
                    text = it, maxLines = 1, overflow = TextOverflow.Ellipsis, color = labelColor
                )
            }
        },
        placeholder = placeholder?.let {
            {
                PrimaryText(
                    text = it,
                    style = MaterialTheme.typography.bodyMedium,
                    color = placeholderColor
                )
            }
        },
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        supportingText = message?.let {
            {
                PrimaryText(
                    text = it,
                    color = if (isError) MaterialTheme.colorScheme.error
                    else MaterialTheme.colorScheme.onSurfaceVariant,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        },
        colors = colors
    )
}