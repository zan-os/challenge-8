package com.example.challenge.presentation.auth.register

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.challenge.presentation.auth.register.components.RegisterForm
import com.example.challenge.presentation.auth.register.components.TopBar
import com.example.challenge.presentation.ui.theme.black
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RegisterScreen(navigator: DestinationsNavigator) {
    Scaffold(topBar = { TopBar() }, backgroundColor = black) {
        RegisterForm(navigator)
    }
}