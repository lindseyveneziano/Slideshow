package com.example.slideshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ImageSliderApp()
            }
        }
    }
}

@Composable
fun ImageSliderApp() {
    val images = listOf(
        Pair(R.drawable.numba1, "Number 1!"),
        Pair(R.drawable.numba2, "Number 2!"),
        Pair(R.drawable.numba3, "Number 3!"),
        Pair(R.drawable.numba4, "Number 4!")
    )

    var currentIndex by remember { mutableStateOf(0) }
    var inputText by remember { mutableStateOf(TextFieldValue()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = images[currentIndex].first),
            contentDescription = "Displayed Image",
            modifier = Modifier.size(250.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = images[currentIndex].second,
            fontSize = 20.sp,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { currentIndex = (currentIndex - 1 + images.size) % images.size }) {
                Text("Back")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(onClick = { currentIndex = (currentIndex + 1) % images.size }) {
                Text("Next")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                label = { Text("Enter Slide #") },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = {
                val index = inputText.text.toIntOrNull()
                if (index != null && index in 1..images.size) {
                    currentIndex = index - 1
                }
            }) {
                Text("Go")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewImageSliderApp() {
    MaterialTheme {
        ImageSliderApp()
    }
}
