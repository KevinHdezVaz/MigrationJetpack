package com.example.migrationjetpack.view.moduls.credit


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
import com.example.front_pagos.view.components.card.CuponBonoRegalo
import com.example.front_pagos.view.components.card.DeliveryAddressCard
import com.example.front_pagos.view.components.card.FooterComponent
import com.example.front_pagos.view.components.card.OrderResumePay
import com.example.front_pagos.view.components.card.PaymentMethodCard
import com.example.front_pagos.view.components.card.ProductItem
import com.example.front_pagos.view.moduls.credit.CompraNormalScreen
import com.example.migrationjetpack.R
import com.example.migrationjetpack.ui.theme.White
import com.example.migrationjetpack.view.navigation.NavigationCompose

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompraNormal(
    onBackClick: () -> Unit,
    onNavigateToNip: () -> Unit
){

    Scaffold(
         topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
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
        CompraNormalScreen(
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
fun DefaultPreview() {
    CompraNormal(
        onBackClick = {},
        onNavigateToNip = {}
    )
}