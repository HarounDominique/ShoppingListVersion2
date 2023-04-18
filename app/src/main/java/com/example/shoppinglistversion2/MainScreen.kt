package com.example.shoppinglistversion2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun ScaffoldScreen() {

    var firstScreen by rememberSaveable { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping List") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(
                        onClick = {
                            firstScreen = true }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        MainScreen(
            firstScreen = firstScreen,
            setFirstScreen = {
                firstScreen = it },

            modifier = Modifier.padding(paddingValues),
        )
    }
}



@Composable
fun MainScreen(
    firstScreen: Boolean,
    setFirstScreen: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val itemsArrayList = remember { mutableStateListOf<String>() }

    Column(modifier = modifier.fillMaxSize()) {
        if (firstScreen) {
            //necesario runtime.*
            var text by rememberSaveable { mutableStateOf("") }
            TextField(value = text, onValueChange = {
                text = it })
            Button(onClick = {
                itemsArrayList.add(text)
                setFirstScreen(false)
            }) {

            }
        } else {
            for (i in itemsArrayList.size - 1 downTo 0) {
                Text(text = itemsArrayList[i])
            }
        }
    }
}