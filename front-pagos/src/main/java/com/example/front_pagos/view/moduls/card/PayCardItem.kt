package com.example.front_pagos.view.moduls.card


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import com.example.front_pagos.ui_theme.White
import com.example.front_pagos.view.components.card.CuponBonoRegalo
import com.example.front_pagos.view.components.card.DeliveryAddressCard
import com.example.front_pagos.view.components.card.FooterComponent
import com.example.front_pagos.view.components.card.OrderResumePay
import com.example.front_pagos.view.components.card.PaymentMethodCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PayCardItem(
    onBackClick: () -> Unit,
    onNavigateToNip: () -> Unit
) {

    Scaffold(
        containerColor = White,
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                title = {
                    Text("Detalle del pedido")
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
        bottomBar = { FooterComponent() }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            OrderDetailContent(
                onNavigateToNip
             )
        }
    }
}

@Composable
private fun OrderDetailContent(
    onNavigateToNip: () -> Unit

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
            .padding(16.dp)

    ) {

        DeliveryAddressCard()

        Spacer(modifier = Modifier.height(16.dp))

        PaymentMethodCard(
            onAddPaymentClick = onNavigateToNip
        )

        CuponBonoRegalo()

        Spacer(modifier = Modifier.height(16.dp))

        OrderResumePay()
    }
}


@Preview
@Composable
fun DefaultPreview() {
    PayCardItem(
        onNavigateToNip = {},
        onBackClick = {})
}
