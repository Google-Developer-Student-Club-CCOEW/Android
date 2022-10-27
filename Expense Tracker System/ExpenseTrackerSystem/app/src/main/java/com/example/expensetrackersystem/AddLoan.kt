package com.example.loan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MainScreen()
        }
    }
}


@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun MainScreen() {

    val tabs = listOf(
        TabItem.Give,
        TabItem.Take
    )

    val pagerState = rememberPagerState(pageCount = tabs.size)

    Scaffold(topBar = { TopBar() }

    )
    {
        Column {

            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "LOAN", fontSize = 18.sp) },
        backgroundColor = Color.Blue,
        contentColor = Color.White
    )
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Color.White,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator()

        }
    ) {
        tabs.forEachIndexed { index, tab ->
            LeadingIconTab(
                icon = { Icon(painter = painterResource(id = tab.icon), contentDescription = "") },
                text = {
                    Text(
                        text = tab.title,
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )

        }
    }
}


@ExperimentalPagerApi
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {

    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}


@Composable
fun give() {
    val name = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val date = remember {
        mutableStateOf("")
    }



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
            Text(text = "GIVEN LOAN PAGE")
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = "Name ") },
                    placeholder = { Text(text = "") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(
                    value = amount.value,
                    onValueChange = { amount.value = it },
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
                    value = date.value,
                    onValueChange = { date.value = it },
                    label = { Text(text = "Date") },
                    placeholder = { Text(text = "") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                        // Toast.makeText(context, "Saved!!", Toast.LENGTH_SHORT).show()
                        //Saves the given loan
                    },
                    modifier = Modifier
                        .fillMaxWidth(8f)
                        // .padding(1.dp)
                        .height(50.dp)
                ) {
                    Text(text = "SAVE")
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                        //  Toast.makeText(context, "", Toast.LENGTH_SHORT).show()

                    },
                    modifier = Modifier
                        .fillMaxWidth(8.8f)

                        // .padding(50.dp)
                        .height(50.dp)
                ) {
                    Text(text = "DONE")
                    //after the loan is clear
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = "Swipe>>")
                }

            }
        }
    }
}

@Composable
fun take() {
    val name = remember { mutableStateOf("") }
    val amount = remember { mutableStateOf("") }
    val date = remember {
        mutableStateOf("")
    }



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
            Text(text = "TAKEN LOAN PAGE")
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = "Name ") },
                    placeholder = { Text(text = "") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier = Modifier.padding(10.dp))

                OutlinedTextField(
                    value = amount.value,
                    onValueChange = { amount.value = it },
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
                    value = date.value,
                    onValueChange = { date.value = it },
                    label = { Text(text = "Date") },
                    placeholder = { Text(text = "") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(8.8f)

                )
                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {
                        //Saves the taken loan
                    },
                    modifier = Modifier
                        .fillMaxWidth(8f)
                        // .padding(1.dp)
                        .height(50.dp)
                ) {
                    Text(text = "SAVE")
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth(8.8f)

                        // .padding(50.dp)
                        .height(50.dp)
                ) {
                    Text(text = "DONE")
                    //after the loan is clear
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(text = "Swipe<<")
                }

            }
        }
    }
}













