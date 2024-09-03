package net.ivanvega.miholamundo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
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
fun OnboardingScreen (modifier: Modifier = Modifier,
                      onContinueClick: ()-> Unit
                      ){
    var  shouldShowOnboarding: MutableState<Boolean>  = remember {
        mutableStateOf(true)
    }
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = "Welcome to de basic compose lab")
        Button(modifier = Modifier.padding(vertical = 24.dp) ,
            onClick = onContinueClick
           ) {
            Text(text = "Continue")
        }
    }

}

@Composable
fun Greetings(modifier: Modifier,
              names: List<String> = List(1000,
                  init = {
                      "$it"
                  }
               )
){
    LazyColumn {
        items(items = names){
           Greeting(name = it)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //var expanded = false
    val expanded = remember {
        mutableStateOf(false)
    }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface (color = MaterialTheme.colorScheme.primary
        , modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row (modifier = Modifier
            .padding(24.dp)) {
            Column (
                modifier =
                Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)

            ) {
                Text(text = "Hello ",
                    )
                Text(text = "$name!",
                    )
            }
            ElevatedButton(
                onClick = {
                    expanded.value = !expanded.value
                }
            )
            {
                Text(text = if (expanded.value) "Show less" else "Show more"  )
            }
        }


    }
}
@Composable
fun MyApp(modifier: Modifier = Modifier,
          names: List<String> = listOf("World", "Android", "Compose","oTRO", "maS", "mAS OTRO")
){
    var  shouldShowOnboarding: MutableState<Boolean> = rememberSaveable{
        mutableStateOf(true)
    }

    Surface(modifier=modifier,
        color = MaterialTheme.colorScheme.background) {
        if (shouldShowOnboarding.value) {
            OnboardingScreen(onContinueClick = {
                shouldShowOnboarding.value = false
            })
        } else {
            /*Column(modifier = modifier.padding(vertical = 20.dp)) {
                for (name in names) {
                    Greeting(name = name)
                }
            }*/
            Greetings(modifier = modifier)
        }
    }


    //OnboardingScreen()


}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MiHolaMundoTheme {
        //Greeting("Perro")
        MyApp()
    }
}


@Preview
@Composable
fun PreviewOnborading(){
    MiHolaMundoTheme {
        //OnboardingScreen()
    }
}