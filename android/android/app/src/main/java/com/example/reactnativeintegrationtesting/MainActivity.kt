package com.example.reactnativeintegrationtesting

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reactnativeintegrationtesting.ui.theme.ReactNativeIntegrationTestingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReactNativeIntegrationTestingTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigateButton(onClick = {
                        startReactActivity()
                    })
                }
            }
        }
    }

    fun startReactActivity() {
        val intent = Intent(this, MyReactActivity::class.java)
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun NavigateButton(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("Open React Native Activity")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ReactNativeIntegrationTestingTheme {
        Greeting("Android")
    }
}