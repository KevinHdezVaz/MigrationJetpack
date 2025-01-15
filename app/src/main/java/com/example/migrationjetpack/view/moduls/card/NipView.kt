package com.example.migrationjetpack.view.moduls.card

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.migrationjetpack.R
import com.example.migrationjetpack.ui.theme.PrimaryRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NipView(
    onBackClick: () -> Unit,
    onNavigateToLogin: () -> Unit,
) {

    Scaffold(
        containerColor = Color.White,

    topBar = {
        TopAppBar(
            modifier = Modifier.shadow(8.dp),
                title = {
                    Text("Prestamo Elektra")
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
    ) { padding ->
    Box(modifier = Modifier.padding(padding)) {
        BodyView(
            onNavigateToLogin = onNavigateToLogin
        )
    }
}

}
    @Composable
    fun BodyView(
        onNavigateToLogin: () -> Unit
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .width(328.dp)
                    .height(129.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.bafp_ic_credit_logo),
                    contentDescription = null,

                    )

                Text(
                    text = "Identifícate capturando los 10 dígitos de tu número celular.",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                )
            }


            Column(
                modifier = Modifier
                    .width(328.dp)
                    .padding(top = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                var phoneNumber by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = phoneNumber,
                    onValueChange = { newValue ->
                         if (newValue.length <= 10 && newValue.all { it.isDigit() }) {
                            phoneNumber = newValue
                        }
                    },
                    label = {
                        Text(
                            text = "Numero de celular",
                            fontSize = 16.sp
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF666666),
                        focusedLabelColor = Color(0xFF666666)
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp
                    )
                )

                Button(
                    onClick = onNavigateToLogin,
                    modifier = Modifier
                        .width(328.dp)
                        .height(82.dp)
                        .padding(top = 28.dp),

                    colors = ButtonDefaults.buttonColors(
                            containerColor = PrimaryRed
                    ),
                    shape = RoundedCornerShape(4.dp)
                ) {
                    Text(
                        text = "Continuar",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }


            Text(
                text = "*Préstamo Elektra es un Credimax (Crédito al Consumo) otorgado por Banco Azteca, S.A., Institución de Banca Múltiple",
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp
                ),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(top = 30.dp, start = 15.dp, end = 15.dp)
                    .height(108.dp)
            )
        }

    }


@Preview
@Composable
fun LoginScreenPreview() {
    NipView (
        onNavigateToLogin = {},
        onBackClick = {})
}
