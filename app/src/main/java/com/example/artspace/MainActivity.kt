package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceMain()
                }
            }
        }
    }
}


@Composable
fun ArtWithTitle(ArtPicture: Int, ArtTitle: String, OriginOfArt: String, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = ArtPicture),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .height(300.dp)
                .width(300.dp)
                .border(border = BorderStroke(2.dp, Color.Gray), shape = RectangleShape)
                .shadow(elevation = 4.dp)
                .padding(10.dp)
        )
        Card(
            modifier = Modifier
                .padding(horizontal = 45.dp, vertical = 90.dp)

        ){
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = ArtTitle,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Start,
                    lineHeight = 30.sp
                )
                Text(
                    text = OriginOfArt,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Composable
fun ArtSpaceMain(){
    val cardModifier = Modifier
        .padding(horizontal = 45.dp)
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    Text(
        text = "Batik Indonesia",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top = 16.dp, bottom = 32.dp)
    )
    var result by remember {
        mutableStateOf(0)
    }
    val totalArtworks = 4
    when (result) {
        1-> ArtWithTitle(
            ArtPicture = R.drawable.batik_parang,
            ArtTitle = stringResource(R.string.parang),
            OriginOfArt= stringResource(id = R.string.solo)
        )
        2-> ArtWithTitle(
            ArtPicture = R.drawable.batik_priyangan,
            ArtTitle = stringResource(R.string.priyangan),
            OriginOfArt = stringResource(id = R.string.tasikmalaya)
        )
        3-> ArtWithTitle(
            ArtPicture = R.drawable.batik_asmat,
            ArtTitle = stringResource(R.string.asmat),
            OriginOfArt = stringResource(id = R.string.papua)
        )
        else-> ArtWithTitle(
            ArtPicture = R.drawable.batik_kawung,
            ArtTitle = stringResource(R.string.kawung),
            OriginOfArt = stringResource(id = R.string.yogyakarta)
        )
    }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 700.dp)
    ) {
        Button(
            onClick = { result = (result - 1 + totalArtworks) % totalArtworks },
            shape = CutCornerShape(5.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp,
                pressedElevation = 50.dp
            )
        ) {
            Text(text = "Back")
        }
        Button(
            onClick = { result = (result + 1) % totalArtworks},
            shape = CutCornerShape(5.dp),
            border = BorderStroke(2.dp, Color.Gray),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 20.dp
            )
        ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceMain()
    }
}