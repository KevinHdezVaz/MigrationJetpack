package com.example.migrationjetpack.view.moduls.credit


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.front_pagos.view.moduls.credit.AutenticationNipScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutenticationNip(
    onBackClick: () -> Unit,
 ) {
    val otpText = remember {
        mutableStateOf("")
    }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(8.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Text("Principal")
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
         AutenticationNipScreen(
            onBackClick = onBackClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview
@Composable
fun AutenticationNipPreview() {
    AutenticationNipScreen(
        onBackClick = { },
        modifier = Modifier
    )
}