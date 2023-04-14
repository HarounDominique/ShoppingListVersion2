package com.example.shoppinglistversion2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppinglistversion2.ui.theme.MainScreen
import com.example.shoppinglistversion2.ui.theme.ShoppingListVersion2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListVersion2Theme {
                // En el setContent sólo hay que llamar a la función, y declararla fuera
                ScaffoldScreen()
            }
        }
    }
}

@Composable
fun ScaffoldScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping List") },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    IconButton(
                        onClick = {  }
                    ){Icon(imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back")}
                }
            )
        }
    ) {
        MainScreen(Modifier.padding(it))
    }
}
