package com.example.migrationjetpack.view.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migrationjetpack.R
import com.example.migrationjetpack.ui.theme.PrimaryRed
import com.example.migrationjetpack.ui.theme.TextDarkGray
import com.example.migrationjetpack.ui.theme.White

@Composable
fun OrderResumePay() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                "Resumen de pago",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium,
                color = TextDarkGray

            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Subtotal (2 producto)")
                Text("$9,498")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Envío")
                Text("$200")
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Descuento")
                Text("-$1,240", color = MaterialTheme.colorScheme.error)
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Total",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "$5000",
                    style = MaterialTheme.typography.titleMedium
                )
            }


        }
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.footer_chkt),
                contentDescription = "Cargando",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 5f),
            )
        }


        Button(
            onClick = { /* Finalizar compra */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryRed,
                contentColor = White
            )
        ) {
            Text("FINALIZAR COMPRA")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = buildAnnotatedString {
                append(
                    "CAT (Costo Anual Total) 99.2% SIN IVA \n\n" +
                            "Los precios incluyen IVA y están expresados en moneda nacional. Al dar clic en “Finalizar compra”, dispondrás de tu línea de crédito. \n\n" +
                            "Al continuar tu compra, autorizas contenido del pagaré por el monto total de crédito. De manera adicional, aceptas haber leído y estar de acuerdo con los términos y condiciones de la promoción “Tu mejor abono”."
                )
            },
            textAlign = TextAlign.Start,
            style = TextStyle(
                color = Color.Gray,
                textDecoration = TextDecoration.Underline,
                lineHeight = 20.sp,
                fontSize = 14.sp
            )
        )

    }

}