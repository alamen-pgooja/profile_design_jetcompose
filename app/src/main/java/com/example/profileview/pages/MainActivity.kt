package com.example.profileview.pages

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import coil.compose.rememberAsyncImagePainter
import com.example.profileview.R
import com.example.profileview.User
import com.example.profileview.UserList
import com.example.profileview.ui.theme.ProfileViewUsingComposeTheme
import com.example.profileview.ui.theme.lightGreen200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(userList: List<User> = UserList) {
    ProfileViewUsingComposeTheme {
        Scaffold(topBar = { CustomAppBar() }) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize() , content = {
                    LazyColumn(content = {
                        items(userList.size) { position ->
                            ProfileCard(user = userList[position])
                        }
                    })
                })
        }
    }


}

@Composable
fun CustomAppBar() {
    TopAppBar(
        title = {
            Text(text = "Top App Bar")
        } ,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Home , "backIcon")
            }
        } ,
        backgroundColor = colors.primary ,
        contentColor = Color.White ,
        elevation = 10.dp
    )
}

@Composable
fun ProfileCard(user: User) {
    Card(
        modifier = Modifier
            .wrapContentHeight(align = Alignment.Top)
            .fillMaxWidth()
            .padding(4.dp)
            .background(
                if (user.status) colors.lightGreen200 else Color.Red
            )
            .shadow(8.dp) ,
        CutCornerShape(topEnd = 20.dp) ,
        Color.White ,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.Start ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImage(user)
            ProfileConnotate(user)
        }
    }
}

@Composable
fun ProfileConnotate(user: User) {
    Column() {
        Text(
            text = user.name ,
            style = MaterialTheme.typography.h5
        )
        Text(
            text = if (user.status) "Online" else "Offline" ,
            style = MaterialTheme.typography.body2
        )
    }
}

@Composable
fun ProfileImage(user: User) {
    Card(
        shape = CircleShape ,
        border = BorderStroke(2.dp , color = colors.background) ,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = user.profileImage , error = painterResource(
                    id = R.drawable.profile_pic
                )
            ) ,
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