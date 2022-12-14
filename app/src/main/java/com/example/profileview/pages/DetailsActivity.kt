package com.example.profileview.pages

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.magnifier
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.profileview.User
import com.example.profileview.pages.ui.theme.ProfileViewUsingComposeTheme

class DetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserDetailsScreen()
        }
    }
}

@Composable
fun UserDetailsScreen() {
    Scaffold(Modifier.safeContentPadding()) { padding ->
        Text(text = "UserDetailsScreen" , Modifier.padding(padding))
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ProfileViewUsingComposeTheme {
        UserDetailsScreen()
    }
}