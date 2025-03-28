package com.example.slideshow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                SlideListScreen()
            }
        }
    }
}

@Composable
fun SlideListScreen() {
    val slideItems = listOf(
        SlideItem(R.drawable.numba1, "Number 1!"),
        SlideItem(R.drawable.numba2, "Number 2!"),
        SlideItem(R.drawable.numba3, "Number 3!"),
        SlideItem(R.drawable.numba4, "Number 4!"),
        SlideItem(R.drawable.numba5, "Number 5!"),
        SlideItem(R.drawable.numba6, "Number 6!"),
        SlideItem(R.drawable.nummba7, "Number 7!"),
        SlideItem(R.drawable.numba8, "Number 8!"),
        SlideItem(R.drawable.numba9, "Number 9!"),
        SlideItem(R.drawable.numba10, "Number 10!")
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(slideItems) { item ->
            SlideCard(item)
        }
    }
}

@Composable
fun SlideCard(item: SlideItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = item.imageResId),
            contentDescription = item.caption,
            modifier = Modifier.size(150.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = item.caption, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlideListScreen() {
    MaterialTheme {
        SlideListScreen()
    }
}
