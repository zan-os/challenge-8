package com.example.challenge.presentation.auth.register.components

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.challenge.presentation.auth.register.RegisterViewModel
import com.example.challenge.presentation.destinations.LoginScreenDestination
import com.example.challenge.presentation.ui.theme.orange
import com.example.challenge.utils.Extensions.showLongToast
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun RegisterForm(
    navigator: DestinationsNavigator,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            placeholder = { Text(text = "Name", fontSize = 16.sp) },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "Name") },
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .offset(y = (-48).dp)

        )
        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Email", fontSize = 16.sp) },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = "Email") },
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .offset(y = (-24).dp)

        )
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password", fontSize = 16.sp) },
            singleLine = true,
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Password") },
            textStyle = TextStyle(fontSize = 14.sp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { navigator.navigate(LoginScreenDestination) },
                text = "Sudah punya akun",
                fontSize = 18.sp,
                color = Color.White,
            )
            Button(
                modifier = Modifier.padding(top = 8.dp),
                onClick = {
                    registerUser(
                        username = username,
                        email = email,
                        password = password,
                        context = context,
                        navigator = navigator,
                        viewModel = viewModel
                    )
                },
                colors = ButtonDefaults.buttonColors(
                    orange
                )
            ) {
                Text(text = "Register")
            }
        }
    }
}

private fun registerUser(
    username: String,
    email: String,
    password: String,
    context: Context,
    navigator: DestinationsNavigator,
    viewModel: RegisterViewModel
) {
    val state = viewModel.state.value

    viewModel.register(username, email, password)
    if (state.user == 0L) {
        context.showLongToast("Something went wrong")
    } else {
        context.showLongToast("Resgistrasi berhasil, silahkan login")
        navigator.navigate(LoginScreenDestination)
    }
}