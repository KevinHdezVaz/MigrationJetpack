package com.example.migrationjetpack.view.components.card

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
import androidx.compose.ui.unit.dp
import com.example.migrationjetpack.ui.theme.BorderGray
import com.example.migrationjetpack.ui.theme.LinkBlue
import com.example.migrationjetpack.ui.theme.TextDarkGray
import com.example.migrationjetpack.ui.theme.White


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
                fontWeight = FontWeight.Medium,
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
                    style = MaterialTheme.typography.bodyMedium
                )
                TextButton(
                    onClick = { /* Cambiar método de pago */ },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = LinkBlue
                    )
                ) {

                    Icon(
                        imageVector = Icons.Default.Add , contentDescription = "Menu Icon",
                        modifier = Modifier.size(16.dp),
                        tint = LinkBlue

                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Agregar", color = LinkBlue)
                }
            }

            HorizontalDivider(color = BorderGray)

            // Card Payment Component
            //  PaymentCardComponent()
        }
    }
}