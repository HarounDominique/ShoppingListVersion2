package com.example.shoppinglistversion2.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier.fillMaxSize()) {
    var firstScreen by rememberSaveable{ mutableStateOf(true) }
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
