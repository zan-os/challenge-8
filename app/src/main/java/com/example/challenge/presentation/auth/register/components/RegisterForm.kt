package com.example.challenge.presentation.auth.register

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenge.presentation.destinations.LoginScreenDestination
import com.example.challenge.presentation.ui.theme.orange
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun RegisterForm(navigator: DestinationsNavigator) {
    var nameText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        TextField(
            value = nameText,
            onValueChange = { nameText = it },
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
            value = emailText,
            onValueChange = { emailText = it },
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
            value = passwordText,
            onValueChange = { passwordText = it },
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
                    .clickable { navigator.navigate(LoginScreenDestination)},
                text = "Sudah punya akun",
                fontSize = 18.sp,
                color = Color.White,
            )
            Button(
                modifier = Modifier.padding(top = 8.dp),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    orange
                )
            ) {
                Text(text = "Register")
            }
        }
    }
}