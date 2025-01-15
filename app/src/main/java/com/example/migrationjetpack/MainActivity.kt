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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.migrationjetpack.ui.theme.MigrationJetpackTheme
import com.example.migrationjetpack.view.components.principalActivity.PaymentMethodItem
import com.example.migrationjetpack.view.components.principalActivity.ToggleButtons
import com.example.migrationjetpack.view.moduls.card.LoginOtp
import com.example.migrationjetpack.view.moduls.card.NipView
import com.example.migrationjetpack.view.moduls.card.PayCardItem
import com.example.migrationjetpack.view.moduls.credit.CompraNormal
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
                        CompraNormal(
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
                        LoginOtp (
                            onBackClick = {
                                navController.navigateUp()
                            }
                        )
                    }
                    composable(NavigationCompose.Nipvie.route) {
                        NipView(
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
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    listOf("DEV", "QA", "PROD").forEach { env ->
                                        OutlinedButton(
                                            onClick = { selectedEnvironment = env },
                                            colors = ButtonDefaults.outlinedButtonColors(
                                                containerColor = if (selectedEnvironment == env)
                                                    MaterialTheme.colorScheme.primaryContainer
                                                else
                                                    MaterialTheme.colorScheme.surface
                                            ),
                                            modifier = Modifier.weight(1f),
                                            contentPadding = PaddingValues(vertical = 4.dp),
                                            shape = RoundedCornerShape(4.dp)
                                        ) {
                                            Text(
                                                env,
                                                style = MaterialTheme.typography.bodySmall
                                            )
                                        }
                                    }
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "DUMMY",
                                        style = MaterialTheme.typography.bodySmall
                                    )

                                    Spacer(modifier = Modifier.width(10.dp))

                                    Switch(
                                        checked = isDummyEnabled,
                                        onCheckedChange = { isDummyEnabled = it }
                                    )
                                }

                                Text(
                                    "Generacion de Token",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = { /* Get Token Logic */ },
                                        modifier = Modifier.width(100.dp),
                                        contentPadding = PaddingValues(vertical = 4.dp)
                                    ) {
                                        Text(
                                            "GET TOKEN",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }
                                    OutlinedTextField(
                                        value = token,
                                        onValueChange = { token = it },
                                        modifier = Modifier.fillMaxWidth().height(48.dp),
                                        textStyle = MaterialTheme.typography.bodySmall,
                                        colors = OutlinedTextFieldDefaults.colors(
                                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                                alpha = 0.3f
                                            )
                                        ),
                                        readOnly = true
                                    )
                                }

                                Text(
                                    "Solicitudes de Pago",
                                    style = MaterialTheme.typography.bodySmall,
                                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                                )


                                OutlinedTextField(
                                    value = email,
                                    onValueChange = { email = it },
                                    label = {
                                        Text(
                                            "Correo:",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth().height(56.dp),
                                    textStyle = MaterialTheme.typography.bodySmall,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                            alpha = 0.3f
                                        )
                                    )
                                )

                                Column {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 4.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            "Concepto Dinámico:",
                                            style = MaterialTheme.typography.bodySmall,
                                            modifier = Modifier.weight(1f)
                                        )
                                        ToggleButtons(
                                            isEnabled = dynamicConcept,
                                            onToggle = { dynamicConcept = it }
                                        )
                                    }

                                    AnimatedVisibility(
                                        visible = !dynamicConcept,
                                        enter = expandVertically() + fadeIn(),
                                        exit = shrinkVertically() + fadeOut()
                                    ) {
                                        OutlinedTextField(
                                            value = conceptoEstatico,
                                            onValueChange = { conceptoEstatico = it },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(bottom = 24.dp),
                                            textStyle = MaterialTheme.typography.bodySmall,
                                            label = {
                                                Text(
                                                    "Concepto: ",
                                                    style = MaterialTheme.typography.bodySmall
                                                )
                                            },
                                            colors = OutlinedTextFieldDefaults.colors(
                                                unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                                    alpha = 0.3f
                                                )
                                            )
                                        )
                                    }
                                }


                                OutlinedTextField(
                                    value = amount,
                                    onValueChange = { amount = it },
                                    label = {
                                        Text(
                                            "Monto:",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    },
                                    modifier = Modifier.fillMaxWidth().height(56.dp),
                                    textStyle = MaterialTheme.typography.bodySmall,
                                    colors = OutlinedTextFieldDefaults.colors(
                                        unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                            alpha = 0.3f
                                        )
                                    )
                                )

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "3Ds:",
                                        style = MaterialTheme.typography.bodySmall,
                                        modifier = Modifier.weight(1f)
                                    )
                                    ToggleButtons(
                                        isEnabled = is3dsEnabled,
                                        onToggle = { is3dsEnabled = it }
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = { /* GET Alta Logic */ },
                                        contentPadding = PaddingValues(
                                            horizontal = 12.dp,
                                            vertical = 4.dp
                                        )
                                    ) {
                                        Text(
                                            "GET ALTA",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }

                                    OutlinedTextField(
                                        value = pagoToken,
                                        onValueChange = { pagoToken = it },
                                        modifier = Modifier.fillMaxWidth().height(48.dp),
                                        textStyle = MaterialTheme.typography.bodySmall,
                                        colors = OutlinedTextFieldDefaults.colors(
                                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                                alpha = 0.3f
                                            )
                                        ),
                                        readOnly = true
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 4.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Button(
                                        onClick = { /* GET Pago Logic */ },
                                        contentPadding = PaddingValues(
                                            horizontal = 12.dp,
                                            vertical = 4.dp
                                        )
                                    ) {
                                        Text(
                                            "GET PAGO",
                                            style = MaterialTheme.typography.bodySmall
                                        )
                                    }

                                    OutlinedTextField(
                                        value = pagoToken,
                                        onValueChange = { pagoToken = it },
                                        modifier = Modifier.fillMaxWidth().height(48.dp),
                                        textStyle = MaterialTheme.typography.bodySmall,
                                        colors = OutlinedTextFieldDefaults.colors(
                                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(
                                                alpha = 0.3f
                                            )
                                        ),
                                        readOnly = true
                                    )
                                }

                            }
                        }
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