package com.example.migrationjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.front_pagos.view.moduls.card.PayCardItem
import com.example.front_pagos.view.moduls.credit.AutenticationNipScreen
import com.example.front_pagos.view.moduls.credit.LoginOtpScreen
import com.example.migrationjetpack.ui.theme.MigrationJetpackTheme
import com.example.migrationjetpack.view.components.principalActivity.ConfigurationSection
import com.example.migrationjetpack.view.components.principalActivity.PaymentMethodItem
import com.example.migrationjetpack.view.moduls.credit.BAFPCreditNipView
import com.example.migrationjetpack.view.moduls.credit.CompraNormal
import com.example.migrationjetpack.view.moduls.credit.LoginOtp
import com.example.migrationjetpack.view.moduls.credit.PhoneNumber
import com.example.migrationjetpack.view.navigation.NavigationCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MigrationJetpackTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavigationCompose.PaymentMethods.route
                ) {
                    composable(NavigationCompose.PaymentMethods.route) {
                        PaymentMethodsScreen(
                            onSettingsClick = {},
                            onPaymentMethodClick = { paymentType ->
                                when (paymentType) {
                                    "elektra_rapido" -> navController.navigate(NavigationCompose.ElektraRapido.route)
                                    "elektra_normal" -> navController.navigate(NavigationCompose.ElektraNormal.route)
                                    "giftcard" -> navController.navigate(NavigationCompose.GiftCard.route)
                                    "nipview" -> navController.navigate(NavigationCompose.Nipvie.route)
                                    "login_otp" -> navController.navigate(NavigationCompose.LoginOtp.route)


                                    else ->navController.navigate(NavigationCompose.GiftCard.route)
                                }
                            }
                        )
                    }
                    composable(NavigationCompose.ElektraRapido.route) {
                        PayCardItem(
                            onBackClick = {
                                navController.navigateUp()
                            },
                            onNavigateToNip = {
                                navController.navigate(NavigationCompose.Nipvie.route)
                            }
                        )
                    }
                    composable(NavigationCompose.ElektraNormal.route) {
                        CompraNormal (
                            onBackClick = {
                                navController.navigateUp()
                            },
                            onNavigateToNip = {
                                navController.navigate(NavigationCompose.Nipvie.route)
                            }
                        )
                    }
                    composable(NavigationCompose.GiftCard.route) {
                        PayCardItem(
                            onBackClick = {
                                navController.navigateUp()
                            },
                            onNavigateToNip = {
                                navController.navigate(NavigationCompose.Nipvie.route)
                            }
                        )
                    }
                    composable(NavigationCompose.LoginOtp.route) {
                        LoginOtp  (
                            onBackClick = {
                                navController.navigateUp()
                            },
                              onNavigateToNip = {
                                navController.navigate(NavigationCompose.AutenticationNip.route)
                            }
                        )
                    }
                    composable(NavigationCompose.AutenticationNip.route) {
                        BAFPCreditNipView  (
                            onBackClick = {
                                navController.navigateUp()
                            }
                        )
                    }
                    composable(NavigationCompose.Nipvie.route) {
                        PhoneNumber(
                            onBackClick = {
                                navController.navigateUp()
                            },
                            onNavigateToLogin = {
                                navController.navigate(NavigationCompose.LoginOtp.route)
                            }
                        )

                    }
                }
            }
            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodsScreen(
    onSettingsClick: () -> Unit,
    onPaymentMethodClick: (String) -> Unit
) {
    var conceptoEstatico by remember { mutableStateOf("") }

    var showSettings by remember { mutableStateOf(true) }
    var isDummyEnabled by remember { mutableStateOf(false) }
    var selectedEnvironment by remember { mutableStateOf("DEV") }
    var token by remember { mutableStateOf("QX13ONJAZCC/LS/B0F0QVKK6UF") }
    var email by remember { mutableStateOf("example@gmail.com") }
    var amount by remember { mutableStateOf("5000") }
    var is3dsEnabled by remember { mutableStateOf(true) }
    var dynamicConcept by remember { mutableStateOf(true) }
    var altaToken by remember { mutableStateOf("2021ALNA-102Q7-NC82-7392-23A591970425") }
    var pagoToken by remember { mutableStateOf("3CM49B0-CEB1-4262-7390-23A59E574C25") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Selecciona una forma de Pago") },
                actions = {
                    IconButton(
                        onClick = { showSettings = !showSettings },
                        modifier = Modifier.size(30.dp),
                    ) {
                        Icon(
                            painterResource(id = R.drawable.settings),
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (showSettings) {
                item {
                    AnimatedVisibility(
                        visible = showSettings,
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        ConfigurationSection(
                            selectedEnvironment = selectedEnvironment,
                            onEnvironmentSelected = { selectedEnvironment = it },
                            isDummyEnabled = isDummyEnabled,
                            onDummyChanged = { isDummyEnabled = it },
                            token = token,
                            onTokenChange = { token = it },
                            email = email,
                            onEmailChange = { email = it },
                            amount = amount,
                            onAmountChange = { amount = it },
                            is3dsEnabled = is3dsEnabled,
                            on3dsChanged = { is3dsEnabled = it },
                            dynamicConcept = dynamicConcept,
                            onDynamicConceptChanged = { dynamicConcept = it },
                            conceptoEstatico = conceptoEstatico,
                            onConceptoEstaticoChange = { conceptoEstatico = it },
                            altaToken = altaToken,
                            onAltaTokenChange = { altaToken = it },
                            pagoToken = pagoToken,
                            onPagoTokenChange = { pagoToken = it }
                        )
                                }


                }
            }



            item {
                PaymentMethodItem(
                    icon = painterResource(id = R.drawable.bafp_ic_elektra),
                    title = "Préstamo elektra",
                    subtitle = "(Compra Rápida)",
                    onClick = { onPaymentMethodClick("elektra_rapido") }
                )
            }

            item {
                PaymentMethodItem(
                    icon = painterResource(id = R.drawable.bafp_ic_elektra),
                    title = "Préstamo elektra",
                    subtitle = "(Compra Normal)",
                    onClick = { onPaymentMethodClick("elektra_normal") }
                )
            }


            item {
                PaymentMethodItem(
                    icon = painterResource(id = R.drawable.bafp_ic_giftcard_empty),
                    title = "GifCard",
                    onClick = { onPaymentMethodClick("giftcard") }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PaymentMethodsScreenPreview() {
    MigrationJetpackTheme {
        PaymentMethodsScreen(
            onSettingsClick = {},
            onPaymentMethodClick = {}
        )
    }
}