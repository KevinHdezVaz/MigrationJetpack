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
 import androidx.compose.ui.unit.Dp
 import kotlinx.coroutines.delay


@Composable
fun OtpView(
    otpText: String,
    otpCount: Int = 7,
    shouldFocusFirst: Boolean = false,
    modifier: Modifier = Modifier,
    paddingHorizontal: Dp = 2.dp,
    paddingInside: Dp = 2.dp,
    borderWidth: Dp = 1.dp,
    borderNormalColor: Color = Color(0xFFE0E0E0),
    textColor: Color = Color.Black,
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium.copy(
        fontSize = 24.sp
    ),    borderShape: Shape = RoundedCornerShape(4.dp),
    onOtpTextChange: (String, Boolean) -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        if (otpText.length > otpCount) {
            throw IllegalArgumentException("Otp text value must not have more than otpCount: $otpCount characters")
        }

        if (shouldFocusFirst) {
            focusRequester.requestFocus()
        }
    }

    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester),
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
            ){
                repeat(otpCount) { index ->
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(paddingInside)
                    ) {
                        CharView(
                            index = index,
                            text = otpText,
                            borderWidth = borderWidth,
                            borderNormalColor = borderNormalColor,
                            textStyle = textStyle,
                            borderShape = borderShape
                        )
                    }
                }
            }
        }
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
    borderWidth: Dp,
    borderNormalColor: Color,
    textStyle: TextStyle,
    borderShape: Shape
) {
    val isFilled = index < text.length
    val char = when {
        index >= text.length -> ""
        else -> text[index].toString()
    }
    val currentBorderColor = when {
        isFilled -> Color.Black
        else -> borderNormalColor
    }
    val textColor = when {
        isFilled -> Color.Black
        else -> Color.Transparent
    }

    Box(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth()
            .border(
                borderWidth,
                currentBorderColor,
                borderShape
            )
            .background(Color.White, borderShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = char,
            style = textStyle,
            color = textColor,
            fontSize = 24.sp

        )
    }
}

@Composable
fun ResendTimer(
    initialTime: Int = 65,
    onResendClick: () -> Unit
) {
    var timeLeft by remember { mutableStateOf(initialTime) }
    var canResend by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (timeLeft > 0) {
            delay(1000L)
            timeLeft--
        }
        canResend = true
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!canResend) {
             val minutes = timeLeft / 60
            val seconds = timeLeft % 60
            Text(
                text = "Reenviar código en ${minutes}:${seconds.toString().padStart(2, '0')}",
                color = Color.Black,
                fontSize = 15.sp
            )
        } else {
            Text(
                text = buildAnnotatedString {
                    append("¿No lo recibiste? ")
                    pushStyle(
                        SpanStyle(
                            color = Color(0xFF0094A2),
                            textDecoration = TextDecoration.Underline
                        )
                    )
                    append("Reenviar código")
                    pop()
                },
                modifier = Modifier.clickable {
                    onResendClick()
                    timeLeft = initialTime
                    canResend = false
                },
                fontSize = 14.sp
            )
        }
    }
}
