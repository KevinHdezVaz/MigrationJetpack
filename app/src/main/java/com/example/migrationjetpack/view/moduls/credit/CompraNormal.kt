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
import androidx.compose.ui.graphics.Color
import com.example.migrationjetpack.R
import com.example.migrationjetpack.ui.theme.White
import com.example.migrationjetpack.view.components.card.CuponBonoRegalo
import com.example.migrationjetpack.view.components.card.DeliveryAddressCard
import com.example.migrationjetpack.view.components.card.FooterComponent
import com.example.migrationjetpack.view.components.card.OrderResumePay
import com.example.migrationjetpack.view.components.card.PaymentMethodCard
import com.example.migrationjetpack.view.components.card.ProductItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompraNormal(
    onBackClick: () -> Unit,
    onNavigateToNip: () -> Unit
) {

    Scaffold(
        containerColor = White,
        topBar = {
            TopAppBar(
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
                onNavigateToNip = onNavigateToNip

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

        PaymentMethodCard(   onAddPaymentClick = onNavigateToNip
        )

        Text(
            text = "Productos",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        ProductItem(
            imageRes = R.drawable.ic_producto_game,
            title = "God of War Ragnarok PS4",
            sku = "1500992284",
            normalPrice = "$ 899",
            discountPrice = "$ 799",
            weeklyPayment = "$ 140",

        )

        ProductItem(
            imageRes = R.drawable.ic_producto_cel,
            title = "Apple iPhone 15 128GB",
            sku = "1500510686",
            normalPrice = "$ 20,999",
            discountPrice = "$ 17,999",
            weeklyPayment = "$ 350",
        )

        CuponBonoRegalo()

        Spacer(modifier = Modifier.height(16.dp))

        OrderResumePay()
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