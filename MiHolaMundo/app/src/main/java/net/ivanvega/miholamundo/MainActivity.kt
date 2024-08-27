package net.ivanvega.miholamundo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.ivanvega.miholamundo.ui.theme.MiHolaMundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MiHolaMundoTheme {
                    MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (color = MaterialTheme.colorScheme.primary ) {
        Text(
            text = "Hello $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}
@Composable
fun MyApp(modifier: Modifier = Modifier){
    Surface(modifier=modifier,
        color = MaterialTheme.colorScheme.background) {
        Greeting(name = "PerroNegro")
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiHolaMundoTheme {
        Greeting("Perro")
    }
}