package com.example.challenge.presentation.auth.login

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.example.challenge.presentation.auth.login.components.LoginForm
import com.example.challenge.presentation.auth.login.components.TopBar
import com.example.challenge.presentation.ui.theme.black
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(navigator: DestinationsNavigator) {
    Scaffold(topBar = { TopBar() }, backgroundColor = black) {
        LoginForm(navigator)
    }
}