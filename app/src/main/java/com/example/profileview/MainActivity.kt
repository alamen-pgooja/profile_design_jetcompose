package com.example.profileview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profileview.ui.theme.ProfileViewUsingComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    ProfileCard()

}

@Composable
fun ProfileCard(/*user model*/) {
    Card(
        modifier = Modifier
            .wrapContentHeight(align = Alignment.Top)
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage()
            ProfileConnotate()
        }
    }
}

@Composable
fun ProfileConnotate() {
    Column() {
        Text(
            text = "Name" ,
            style = MaterialTheme.typography.h5
        )
        Text(
            text = "Description" ,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun ProfileImage() {
    Card(
        shape = CircleShape ,
        border = BorderStroke(2.dp , color = Color.Green) ,
        modifier = Modifier
//            .shadow(8.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_pic) ,
            contentScale = ContentScale.FillBounds ,
            contentDescription = stringResource(id = R.string.app_name) ,
            modifier = Modifier
                .size(72.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileViewUsingComposeTheme {
        MainScreen()
    }
}