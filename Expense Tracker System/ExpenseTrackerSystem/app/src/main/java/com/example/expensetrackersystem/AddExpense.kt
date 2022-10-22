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

class AddExpense : ComponentActivity() {
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
                                    Text(text = "EXPENSE PAGE")
                                },
                                navigationIcon = {
                                    IconButton(onClick = { }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = "arrow")
                                    }
                                },
                                actions = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            Icons.Filled.Notifications,
                                            contentDescription = "noti"
                                        )
                                    }

                                }
                            )


                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                IconButton(onClick = { }) {
                                    Icon(Icons.Filled.Add, contentDescription = "add")
                                }
                            }
                        },
                        floatingActionButtonPosition = FabPosition.End
                    ) {

                    }

                }
                Expense(applicationContext)
            }
        }
    }
}
                    


@Composable
fun Expense(context: android.content.Context) {
    var name = remember {
        mutableStateOf("")
    }
    var budgetname = remember {
        mutableStateOf("")
    }
    var amountInput = remember {
        mutableStateOf("")
    }
    var note = remember {
        mutableStateOf("")
    }
    var date = remember {
        mutableStateOf("")
    }


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


            androidx.compose.foundation.layout.Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                androidx.compose.material.OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = " NAME") },
                    placeholder = { Text(text = "") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(10.dp))

                androidx.compose.material.OutlinedTextField(
                    value = budgetname.value,
                    onValueChange = { budgetname.value = it },

                    label = { Text(text = "BudgetName") },
                    placeholder = { Text(text = "") },
                    singleLine = true,

                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                androidx.compose.foundation.layout.Spacer(
                    modifier =
                    Modifier.padding(10.dp)
                )

                //Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = amountInput.value,
                    onValueChange = { amountInput.value = it },
                    label = { Text(text = "Amount") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction =  ImeAction.Next
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(8.8f)
                )
                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(
                    value = note.value,
                    onValueChange = { note.value = it },
                    label = { Text(text = "KeepNotes") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)
                )
                Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = date.value,
                    onValueChange = { date.value = it },
                    label = { Text(text = "Date") },
                    placeholder = { Text(text = "Month Date, Year") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                androidx.compose.material.Button(
                    onClick = {
                        android.widget.Toast.makeText(
                            context,
                            "SAVED!!",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()

                    },
                    modifier = Modifier
                        .fillMaxWidth(8.8f)
                        .height(50.dp)
                ) {
                    Text(text = "SAVE")
                }

                androidx.compose.foundation.layout.Spacer(modifier = Modifier.padding(20.dp))

            }
        }
    }
}







