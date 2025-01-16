package com.example.front_pagos.view.components.others

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_pagos.ui_theme.PrimaryRed
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun ButtonContinuar(
    text : String,
    onClick: () -> Unit,
     enabled: Boolean = true,
    paddingHorizontal: Int = 20,
){
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier
            .padding(horizontal = paddingHorizontal.dp)
             .fillMaxWidth()
            .height(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryRed,
            disabledContainerColor = PrimaryRed.copy(alpha = 0.5f)
        ),
        shape = RoundedCornerShape(6.dp),
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.White
        )
    }
}
