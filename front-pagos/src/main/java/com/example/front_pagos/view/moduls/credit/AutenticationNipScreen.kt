package com.example.front_pagos.view.moduls.credit


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_pagos.R
import com.example.front_pagos.logic.credit.NipRules
import com.example.front_pagos.logic.credit.NipRules.Companion.validateNoConsecutiveNumbers
import com.example.front_pagos.logic.credit.NipRules.Companion.validateNoRepeatedNumbers
import com.example.front_pagos.logic.credit.NipRules.Companion.validateSixDigits
import com.example.front_pagos.ui_theme.PrimaryRed
import com.example.front_pagos.view.components.card.NipAutenticationComponent
import com.example.front_pagos.view.components.others.ButtonContinuar


@Composable
fun AutenticationNipScreen(
    onBackClick: () -> Unit,
    modifier: Modifier

) {
    val otpText = remember { mutableStateOf("") }
    val rules = remember { mutableStateOf(NipRules()) }

    fun validateNip(nip: String) {
        rules.value = NipRules(
            hasSixDigits = validateSixDigits(nip),
            noConsecutiveNumbers = validateNoConsecutiveNumbers(nip),
            noRepeatedNumbers = validateNoRepeatedNumbers(nip)
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ahora crea un NIP",
            modifier = Modifier
                .padding(top = 47.dp, bottom = 40.dp),
            fontSize = 28.sp,
            color = Color(0xFF333333),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        NipAutenticationComponent(
            otpText = otpText.value,
            onOtpTextChange = { value, isComplete ->
                otpText.value = value
                validateNip(value)
            }
        )

        Text(
            text = "Te recomendamos no utilizar fechas importantes y considera las siguientes caracteristicas:",
            fontSize = 15.sp,
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 16.dp)
        )

        Column(
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            RuleItem(text = "Debe tener 6 dígitos", isActive = rules.value.hasSixDigits)
            RuleItem(text = "Sin números consecutivos", isActive = rules.value.noConsecutiveNumbers)
            RuleItem(text = "Sin números repetidos", isActive = rules.value.noRepeatedNumbers)
        }

        Spacer(modifier = Modifier.height(20.dp))


    ButtonContinuar(
        "continuar",
        onClick = {}
    )
    }
}
@Composable
private fun RuleItem(
    text: String,
    isActive: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = if (isActive) {
                painterResource(id = R.drawable.bafp_credit_ic_positive)
            } else {
                painterResource(id = R.drawable.bafp_credit_ic_disable)
            },
            contentDescription = null,
            tint = if (isActive) Color(0xFF4CAF50) else Color(0xFFBDBDBD),
            modifier = Modifier.padding(end = 15.dp)
        )

        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF333333)
        )
    }
}

