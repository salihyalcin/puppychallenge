/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {

                val dogs = arrayListOf<Dog>()
                dogs.add(Dog(1, "Tom", R.drawable.tom))
                dogs.add(Dog(2, "Joe", R.drawable.joe))
                dogs.add(Dog(3, "Lenny", R.drawable.lenny))
                dogs.add(Dog(4, "Kelly", R.drawable.kelly))
                dogs.add(Dog(5, "White", R.drawable.white))
                dogs.add(Dog(6, "Tutu", R.drawable.tutu))
                dogs.add(Dog(7, "Lulu", R.drawable.lulu))
                dogs.add(Dog(8, "Mumu", R.drawable.mumu))
                dogs.add(Dog(9, "Nunu", R.drawable.nunu))
                dogs.add(Dog(10, "Coco", R.drawable.coco))

                DogList(dogs = dogs)
            }
        }
    }
}

// Start building your app here!
@Composable
fun DogList(dogs: List<Dog>) {
    val navController = rememberNavController()
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            items(dogs) { dog ->
                DogListItem(
                    dog, navController
                )
            }
        }
    }
    NavHost(navController, startDestination = "dogs") {
        composable("dogs") { MainActivity() }
        composable("dogDetail/{dogName}/{dogImage}") { backStackEntry ->
            DogDetail(
               backStackEntry.arguments?.getString(
                    "dogName"
                )!!,
                backStackEntry.arguments?.getString(
                    "dogImage"
                )
            )
        }
    }
}

@Composable
fun DogListItem(dog: Dog, navController: NavHostController) {
    val context = LocalContext.current
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable(onClick = { navController.navigate("dogDetail/" +dog.name+"/"+ dog.image.toString()) })
            .fillMaxWidth(),
    ) {
        Image(
            painter = painterResource(id = dog.image),
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp)
                .padding(10.dp),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(dog.name)
        }
    }

}


@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
    }
}
