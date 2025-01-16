package com.example.front_pagos.view.components.card

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
import com.example.front_pagos.ui_theme.BorderGray
import com.example.front_pagos.ui_theme.LinkBlue
import com.example.front_pagos.ui_theme.TextDarkGray
import com.example.front_pagos.ui_theme.White
@Composable
  fun CuponBonoRegalo() {
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
                "Cupon o bono de regalo",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = TextDarkGray

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "¿Tienes un cupon o bono de regalo?",
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    style = MaterialTheme.typography.bodyMedium,
                )
                TextButton(
                    onClick = { /* Cambiar método de pago */ },
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
                    Text("Agregar", color = LinkBlue,fontSize = 17.sp)
                }
            }

            HorizontalDivider(color = BorderGray)

            // Card Payment Component
            //  PaymentCardComponent()
        }
    }
}

@Preview
@Composable
fun vistaCupon(){
    CuponBonoRegalo()
}