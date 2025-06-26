package com.example.zengarden.plants.presentation.composable.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zengarden.ui.theme.ZenGardenTheme

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    shape: Shape = RoundedCornerShape(5.dp),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    style: TextStyle = TextStyle.Default,
    paddingValues: PaddingValues = PaddingValues(5.dp),
    minLines: Int = 1,
    backgroundColor: Color,
    textColor: Color,
    label: @Composable () -> Unit = {},

    singleLine: Boolean = true
) {
    var isFocused by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = shape
            )
            .padding(paddingValues)
    ) {
        label()
        Spacer(Modifier.width(5.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = style.merge(TextStyle(color = textColor)),
            keyboardOptions = keyboardOptions,
            singleLine = singleLine,
            minLines = minLines,
            cursorBrush = SolidColor(textColor),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { isFocused = it.isFocused }
        ) { innerTextField ->

            Box(
                modifier = Modifier

            ) {
                if (value.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = style,
                        color = textColor
                    )
                }
                innerTextField()

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    ZenGardenTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = ZenGardenTheme.colors.error
                )
        ) {
            var text by remember { mutableStateOf("") }
            CustomTextField(
                value = text,
                onValueChange = {text = it},
                backgroundColor = ZenGardenTheme.colors.tretiary,
                style = ZenGardenTheme.typography.body,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                textColor = ZenGardenTheme.colors.onTretiary,
                modifier = Modifier
                    .width(60.dp)

            )
        }
    }
}
