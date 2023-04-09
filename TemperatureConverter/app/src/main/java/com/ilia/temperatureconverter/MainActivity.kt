package com.ilia.temperatureconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.material.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MainActivityContent()
                }
            }
        }
    }
}

@Composable
fun Comp1(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("COURSE 1")
    }
}

@Composable
fun Comp2(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("COURSE 2")
    }
}

@Composable
fun Comp3(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("COURSE 3")
    }
}




@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun CourseText(celsius: Int) {
    Text("")
}

@Composable
fun MainActivityContent() {
    val celsius = remember { mutableStateOf(0) }
    val newCelsius = remember { mutableStateOf("") }
    val randomText = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
        Header(R.drawable.img, "Courses")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Comp1 {
                randomText.value = "1"
            }
            Comp2 {
                randomText.value = "2"
            }
            Comp3 {
                randomText.value = "3"
            }
        }
        if (randomText.value.isNotEmpty()) {
            Text(randomText.value)
        } else {
            CourseText(celsius.value)
        }
    }
}

//used this to test the buttons
/*
fun getRandomText(): String {
    val texts = listOf(
        "Hello",
        "World",
        "Jetpack Compose",
        "Android",
        "Kotlin",
    )
    return texts[Random.nextInt(texts.size)]
}
*/

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    MaterialTheme {
        Surface {
            MainActivityContent()
        }
    }
}