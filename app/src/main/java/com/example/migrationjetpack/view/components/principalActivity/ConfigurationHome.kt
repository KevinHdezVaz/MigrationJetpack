package com.example.migrationjetpack.view.components.principalActivity



import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ConfigurationSection(
    selectedEnvironment: String,
    onEnvironmentSelected: (String) -> Unit,
    isDummyEnabled: Boolean,
    onDummyChanged: (Boolean) -> Unit,
    token: String,
    onTokenChange: (String) -> Unit,
    email: String,
    onEmailChange: (String) -> Unit,
    amount: String,
    onAmountChange: (String) -> Unit,
    is3dsEnabled: Boolean,
    on3dsChanged: (Boolean) -> Unit,
    dynamicConcept: Boolean,
    onDynamicConceptChanged: (Boolean) -> Unit,
    conceptoEstatico: String,
    onConceptoEstaticoChange: (String) -> Unit,
    altaToken: String,
    onAltaTokenChange: (String) -> Unit,
    pagoToken: String,
    onPagoTokenChange: (String) -> Unit,
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
                        onClick = { onEnvironmentSelected(env) },
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
                            fontWeight = FontWeight.Bold,
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
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.width(10.dp))
                Switch(
                    checked = isDummyEnabled,
                    onCheckedChange = onDummyChanged
                )
            }
            Text(
                "Generacion de Token",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Bold,
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
                    onValueChange = onTokenChange,
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
                fontWeight = FontWeight.Bold,

                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = onEmailChange,
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
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    ToggleButtons(
                        isEnabled = dynamicConcept,
                        onToggle = onDynamicConceptChanged
                    )
                }
                AnimatedVisibility(
                    visible = !dynamicConcept,
                    enter = expandVertically() + fadeIn(),
                    exit = shrinkVertically() + fadeOut()
                ) {
                    OutlinedTextField(
                        value = conceptoEstatico,
                        onValueChange = onConceptoEstaticoChange,
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
                onValueChange = onAmountChange,
                label = {
                    Text(
                        "Monto:",
                        fontWeight = FontWeight.Bold,
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
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
                ToggleButtons(
                    isEnabled = is3dsEnabled,
                    onToggle = on3dsChanged
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
                    value = altaToken,
                    onValueChange = onAltaTokenChange,
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
                    onValueChange = onPagoTokenChange,
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

@Preview(showBackground = true)
@Composable
fun ConfigurationSectionPreview() {
    var selectedEnvironment by remember { mutableStateOf("DEV") }
    var isDummyEnabled by remember { mutableStateOf(false) }
    var token by remember { mutableStateOf("QX13ONJAZCC/LS/B0F0QVKK6UF") }
    var email by remember { mutableStateOf("example@gmail.com") }
    var amount by remember { mutableStateOf("5000") }
    var is3dsEnabled by remember { mutableStateOf(true) }
    var dynamicConcept by remember { mutableStateOf(true) }
    var conceptoEstatico by remember { mutableStateOf("") }
    var altaToken by remember { mutableStateOf("2021ALNA-102Q7-NC82-7392-23A591970425") }
    var pagoToken by remember { mutableStateOf("3CM49B0-CEB1-4262-7390-23A59E574C25") }

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