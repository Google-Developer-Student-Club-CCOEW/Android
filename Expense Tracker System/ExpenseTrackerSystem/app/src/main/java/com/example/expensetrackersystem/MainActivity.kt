package com.example.expensetrackersystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensetrackersystem.ui.theme.ExpenseTrackerSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExpenseTrackerSystemTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize()) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Welcome to Expense Tracker System")
                                },


                            )


                        },

                    ){

                    }

                }

                instru(applicationContext)
                //call loginscreen here
            }
        }
    }
}

@Composable
fun instru(context:Context) {
    androidx.compose.foundation.layout.Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    )
    {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier
                .fillMaxSize(),
            //.background(Color.White),
            contentAlignment = androidx.compose.ui.Alignment.TopCenter
        ) {

        }
        androidx.compose.foundation.layout.Column(
            horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
            verticalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth(0.60f)
                .padding(10.dp)

        ) {
            Column() {


            Text(
                text = "1. Category Trends and Budget",
                modifier = Modifier.fillMaxWidth(),
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )}
            Column() {

                Text(
                    text = "Insightful trends and budget alerts for expense categories",
                    modifier = Modifier,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column() {
                Text(
                    text = "2. Add Your expenses",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Column() {
                Text(text = "Quickly add your cash expenses using robust and simple form",
                    modifier = Modifier,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column {
                Text(
                    text = "3. Add Your income",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            //  Spacer(modifier = Modifier.padding(10.dp))

            Column() {
                Text(text ="Quickly add your income and the categories to it",
                    modifier = Modifier,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.padding(10.dp))
            Column() {
                Text(
                    text = "4. Quick Searches",
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Red,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
            Column() {
                Text(text = "Search and sort through all your transactions at one single place",
                    modifier = Modifier,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.padding(80.dp))


            Button(
                onClick = {
                    Toast.makeText(context, "Welcome!!", Toast.LENGTH_SHORT).show()

                },

                modifier = Modifier
                    .fillMaxWidth(8f)
                    .height(50.dp)

            ) {
                Text(text = "NEXT")
            }
            Spacer(modifier = Modifier.padding(20.dp))






        }
    }
}



