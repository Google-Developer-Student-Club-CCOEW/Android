package com.example.loginpage

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily.Companion.Monospace
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginpageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginpageTheme {
                Surface(modifier = Modifier.fillMaxSize()) {

                    Login(applicationContext)
                }
            }
        }
    }
}

@Composable
fun Login(context: Context) {
    val emailvalue = remember { mutableStateOf("") }
    val passwordvalue = remember { mutableStateOf("") }
    val passwordVisibility= remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            //.background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(0.60f)
                .padding(10.dp)

        ) {
            Text(text = "LOGIN PAGE")
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = emailvalue.value,
                    onValueChange = { emailvalue.value = it },
                    label = {Text(text="Email ")},
                    placeholder = { Text(text = "name@gmail.com")},
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(value = passwordvalue.value,
                    onValueChange = {passwordvalue.value=it},
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value=!passwordVisibility.value
                        }) {


                        }
                    },
                    label={ Text(text = "Password")},
                    placeholder = { Text(text = "Password")},
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier =
                Modifier.padding(10.dp))
                Button(onClick = {
                    Toast.makeText(context,"LOGIN SUCCESSFULL!!", Toast.LENGTH_SHORT).show()

                },
                    modifier = Modifier
                        .fillMaxWidth(8.8f)
                        .height(50.dp)
                ) {
                    Text(text = "LOGIN")
                }

                Spacer(modifier = Modifier.padding(20.dp))

            }
        }
    }
}








