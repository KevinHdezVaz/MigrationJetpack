package com.example.front_pagos.view.components.principalActivity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GetButtonSection(
    tokenValue: String,
    buttonText: String,
    onButtonClick: () -> Unit,
    onTokenChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = onButtonClick,
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
        ) {
            Text(
                buttonText,
                style = MaterialTheme.typography.bodySmall
            )
        }

        OutlinedTextField(
            value = tokenValue,
            onValueChange = onTokenChange,
            modifier = Modifier.weight(1f),
            textStyle = MaterialTheme.typography.bodySmall,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
            ),
            readOnly = true
        )
    }
}

@Composable
fun GetButtonsGroup(
    token: String,
    altaToken: String,
    pagoToken: String,
    onGetToken: () -> Unit,
    onGetAlta: () -> Unit,
    onGetPago: () -> Unit,
    onTokenChange: (String) -> Unit,
    onAltaTokenChange: (String) -> Unit,
    onPagoTokenChange: (String) -> Unit,
) {

    Text(
        "Generacion de Token",
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
    )
    GetButtonSection(
        tokenValue = token,
        buttonText = "GET TOKEN",
        onButtonClick = onGetToken,
        onTokenChange = onTokenChange
    )

    Spacer(modifier = Modifier.height(8.dp))

    // Alta Token Section
    GetButtonSection(
        tokenValue = altaToken,
        buttonText = "GET ALTA",
        onButtonClick = onGetAlta,
        onTokenChange = onAltaTokenChange
    )

    // Pago Token Section
    GetButtonSection(
        tokenValue = pagoToken,
        buttonText = "GET PAGO",
        onButtonClick = onGetPago,
        onTokenChange = onPagoTokenChange
    )
}