package com.example.front_pagos.view.components.card



import com.example.front_pagos.ui_theme.White
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.front_pagos.R


@Composable
fun ProductItem(
    imageRes: Int,
    title: String,
    sku: String,
    normalPrice: String,
    discountPrice: String,
    weeklyPayment: String,

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
    )  {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        IconButton(
                            onClick = {  }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Eliminar"
                            )
                        }
                    }

                    Text(
                        text = "SKU: $sku",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = normalPrice,
                            style = MaterialTheme.typography.bodyMedium,
                            textDecoration = TextDecoration.LineThrough
                        )
                        Text(
                            text = discountPrice,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = "$weeklyPayment semanales con ",
                    style = MaterialTheme.typography.bodyMedium
                )
                Image(
                    painter = painterResource(id = R.drawable.bafp_ic_credit_logo),
                    contentDescription = null,
                    modifier = Modifier.height(15.dp)
                )
            }
            Spacer(Modifier.height(25.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { }
                ) {
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontSize = 34.sp,
                            color = Color.Black
                        )
                    )

                }

                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, Color.Black, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .size(120.dp, 30.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "1 pieza",
                        color = Color.Black
                    )
                }
                IconButton(
                    onClick = {  }
                ) {
                    Icon(
                        imageVector = Icons.Default.Add ,
                        contentDescription = "Aumentar"
                    )
                }
            }

            Spacer(Modifier.height(25.dp))
            Text(
                text = "Recibe en C.P. 14000 entre 5 a 7 días",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Envío gratis",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF009F03)
            )
            Text(
                text = "Vendido por Gamer Center",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}