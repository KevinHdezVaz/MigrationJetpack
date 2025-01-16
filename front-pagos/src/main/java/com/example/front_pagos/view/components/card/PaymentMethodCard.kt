package com.example.front_pagos.view.components.card


import com.example.front_pagos.ui_theme.BorderGray
import com.example.front_pagos.ui_theme.LinkBlue
import com.example.front_pagos.ui_theme.TextDarkGray
import com.example.front_pagos.ui_theme.White
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
  fun PaymentMethodCard(
    onAddPaymentClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Forma de Pago",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = TextDarkGray,
                fontSize = 17.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Agrega una direccion o tienda para seleccionar una forma de pago.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                )
                TextButton(
                    onClick = onAddPaymentClick,
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = LinkBlue
                    )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add , contentDescription = "Menu Icon",
                        modifier = Modifier.size(25.dp),
                        tint = LinkBlue

                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Agregar", color = LinkBlue, fontSize = 17.sp)
                }
            }

            HorizontalDivider(color = BorderGray)
            //  PaymentCardComponent()
        }
    }
}


@Composable
@Preview
fun previa(){

    PaymentMethodCard(
        onAddPaymentClick = {}
    )
}
