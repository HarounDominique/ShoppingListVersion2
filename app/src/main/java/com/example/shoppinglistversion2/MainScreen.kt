package com.example.shoppinglistversion2

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun ScaffoldScreen() {


    var firstScreen by rememberSaveable{ mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping List") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(
                        onClick = { firstScreen = true }
                    ){
                        Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        MainScreen(Modifier.padding(it))
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    var itemsArrayList by rememberSaveable{ mutableStateOf(arrayListOf<String>())}

    if (firstScreen) {
        Column() {
            //necesario runtime.*
            var text by rememberSaveable { mutableStateOf("") }
            TextField(value = text, onValueChange = { text = it })
            Button(onClick = {
                itemsArrayList.add(text)
                firstScreen=false
            }) {

            }
        }
    } else {
        Column() {
            for (i in itemsArrayList.size-1 downTo 0){
                Text(text = itemsArrayList[i])
            }
        }
    }
}
