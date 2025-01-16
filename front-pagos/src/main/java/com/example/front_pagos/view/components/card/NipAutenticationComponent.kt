package com.example.front_pagos.view.components.card


 import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
 import androidx.compose.foundation.shape.CircleShape
 import androidx.compose.foundation.text.BasicTextField
 import androidx.compose.foundation.text.KeyboardOptions
 import androidx.compose.material3.Text
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
 import androidx.compose.ui.tooling.preview.Preview
 import androidx.compose.ui.unit.Dp
 import kotlinx.coroutines.delay

@Composable
fun NipAutenticationComponent(
    otpText: String,
    otpCount: Int = 6,
    modifier: Modifier = Modifier,
    onOtpTextChange: (String, Boolean) -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    BasicTextField(
        modifier = modifier.focusRequester(focusRequester),
        singleLine = true,
        value = TextFieldValue(otpText, selection = TextRange(otpText.length)),
        onValueChange = {
            if (it.text.length <= otpCount) {
                onOtpTextChange.invoke(it.text, it.text.length == otpCount)
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
            ) {
                repeat(otpCount) { index ->
                    NipDigitBox(
                        isFilled = index < otpText.length,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    )
}

@Composable
private fun NipDigitBox(
    isFilled: Boolean,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(55.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (isFilled) Color.Black else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(4.dp)
            )
            .background(Color.White, RoundedCornerShape(4.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (isFilled) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .background(Color.Black, CircleShape)
            )
        }
    }
}
