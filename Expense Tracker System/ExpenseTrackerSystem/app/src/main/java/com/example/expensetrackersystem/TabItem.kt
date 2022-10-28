package com.example.loan

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var icon: Int, var title: String, var screen: ComposableFun) {
    object Give : TabItem(R.drawable.ic_give, "Give", { give() })
    object Take : TabItem(R.drawable.ic_take, "Take", { take() })
}
