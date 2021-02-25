package com.example.androiddevchallenge

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.purple500

import com.example.androiddevchallenge.ui.theme.whiteColor

@Composable
fun DogDetail(name: String, imageId: String?) {
    Surface(Modifier.background(color = whiteColor)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Text(
                text = "Puppy Detail",
                modifier = Modifier
                    .height(50.dp)
                    .padding(5.dp)
                    .background(purple500)
                    .fillMaxWidth(),
                color = whiteColor,
            )
            Image(
                painter = painterResource(id = imageId!!.toInt()),
                contentDescription = null,
                modifier = Modifier
                    .height(300.dp)
                    .width(300.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(name)
            }
        }
    }

}
