package com.example.migrationjetpack.view.moduls.credit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_pagos.view.components.card.OtpView
import com.example.front_pagos.view.components.card.ResendTimer
import com.example.front_pagos.view.moduls.credit.LoginOtpScreen
import com.example.front_pagos.view.moduls.credit.PhoneNumberScreen
import com.example.migrationjetpack.ui.theme.PrimaryRed


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginOtp(
    onBackClick: () -> Unit,
    onNavigateToNip: () -> Unit,
    ) {
    val otpText = remember {
        mutableStateOf("")
    }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text("Prestamo Exxxxlektra")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Menu Icon"
                        )
                    }
                },
            )
        },
    ) { padding ->
        LoginOtpScreen (
            onBackClick = onBackClick,
            onNavigateToNip = onNavigateToNip,
            modifier = Modifier.padding(
                vertical = 60.dp
            )
        )
    }
}



@Preview
@Composable
fun LoginOtpScreenScreenPreview() {
    LoginOtpScreen (
        onBackClick = {},
        onNavigateToNip = {},
        modifier = Modifier
    )
}
