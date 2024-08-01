package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        message = "",
                        from = "",
                        modifier = Modifier.padding(innerPadding)
                    )
                    //GreetingImage(
                        //message = "",
                        //from = "",
                        //modifier = Modifier.padding(innerPadding)
                    //)
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = "From Wilbert",
                        modifier = Modifier.padding(25.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.Center) {
        Text(
            text = message,
            modifier = Modifier.padding(start = 1.dp, top = 5.dp, end =1.dp, bottom = 10.dp),
            fontSize = 70.sp,
            lineHeight = 115.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 40.sp,
            modifier = Modifier
                .background(color = Color.Cyan)
                .padding(start = 15.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                //.align(alignment = Alignment.End)
                .align(alignment = Alignment.CenterHorizontally)

        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box(modifier.padding(top = 15.dp)) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.9F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.signature_text)
        )
    }
}
