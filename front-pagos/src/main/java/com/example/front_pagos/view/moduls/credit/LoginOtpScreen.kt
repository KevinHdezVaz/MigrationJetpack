package com.example.front_pagos.view.moduls.credit

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
import com.example.front_pagos.ui_theme.PrimaryRed
import com.example.front_pagos.view.components.card.OtpView
import com.example.front_pagos.view.components.card.ResendTimer

@Composable
fun LoginOtpScreen(
    onBackClick: () -> Unit,
    modifier: Modifier
) {
    val otpText = remember {
        mutableStateOf("")
    }
    Scaffold(
        modifier =  modifier,
        containerColor = Color.White,

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    fontWeight = FontWeight.Bold,
                    text = "Códigoxxx de verificación",
                    style = MaterialTheme.typography.titleLarge,
                    color = PrimaryRed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )


                Text(
                    text = "Enviamos un SMS con un código a tu número.",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                Spacer(modifier = Modifier.height(40.dp))


                OtpView(
                    otpText = otpText.value,
                    onOtpTextChange = { value, isComplete ->
                        otpText.value = value
                    },
                    textStyle = MaterialTheme.typography.headlineMedium.copy(
                        fontSize = 24.sp
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))

                ResendTimer(
                    onResendClick = {
                    }
                )
            }

            Spacer(Modifier.height(70.dp))

            Button(
                onClick = { /* handle verification */ },
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryRed,
                    disabledContainerColor = PrimaryRed.copy(alpha = 0.5f)
                ),
                enabled = otpText.value.length == 7,
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = "Verificar Código",
                    color = Color.White,
                    fontSize = 14.sp
                )
            }

        }
    }
}
