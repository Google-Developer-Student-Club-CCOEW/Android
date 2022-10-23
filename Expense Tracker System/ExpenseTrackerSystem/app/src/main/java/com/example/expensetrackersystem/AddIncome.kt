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

class AddIncome : ComponentActivity() {
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
                                    Text(text = "INCOME PAGE")
                                },
                                navigationIcon = {
                                    IconButton(onClick = { }) {
                                        Icon(Icons.Filled.ArrowBack, contentDescription = "arror")
                                    }
                                },
                                actions = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            Icons.Filled.Send,
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
                dropDownMenu(application)
            }
        }
    }
}
            
@SuppressLint("UnrememberedMutableState")
@Composable
fun dropDownMenu(context: android.content.Context) {
    var name = remember {
        mutableStateOf("")
    }

    var incomeamount = remember {
        mutableStateOf("")
    }
    var note = remember {
        mutableStateOf("")
    }
    var expanded by remember {

        mutableStateOf(false)}
    val list = listOf("StockMarket", "Job", "Bank", "Freelancing", "Other")
    var selecteditem by remember {
        mutableStateOf("")
    }
    var textFieldSize = remember {
        mutableStateOf(Size.Zero)
    }

    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowUp
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


                //Spacer(modifier = Modifier.padding(10.dp))
                OutlinedTextField(
                    value = incomeamount.value,
                    onValueChange = { incomeamount.value = it },
                    label = { Text(text = "Amount") },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
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

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    OutlinedTextField(
                        value = selecteditem,
                        onValueChange = { selecteditem= it },

                        modifier = Modifier
                            .fillMaxWidth()
                            .onGloballyPositioned { coordinates ->
                                //textFieldSize=coordinates.size.toSize()
                            },
                        label = { Text(text = "Category") },
                        trailingIcon = {
                            Icon(icon, "", Modifier.clickable { expanded = !expanded })
                        },
                        //singleLine = true,

                    )
                    //Spacer(modifier = Modifier.padding(10.dp))

                    DropdownMenu(
                        expanded = expanded, onDismissRequest = { expanded = false },
                        modifier = Modifier

                            .padding(20.dp)
                    ) {
                        list.forEach { label ->
                            DropdownMenuItem(onClick = {
                                selecteditem = label
                                expanded = false
                            }) {
                                Text(text = label)
                            }
                        }
                    }

                }
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





