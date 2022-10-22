package com.example.roomdatabase.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.ui.theme.*
import com.example.roomdatabase.viewmodel.TextViewModel


@Composable
fun List(navController: NavController) {
    val viewModel: UserViewModel = viewModel()
    val userList by viewModel.readAllData.observeAsState()
    Scaffold(
        topBar = {
            // this function below
            TopBar {

                viewModel.deleteAllUser()

            }
        },
        floatingActionButton = { Floating(navController) },
        backgroundColor = if (isSystemInDarkTheme())
            dark
        else
            lightGray
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),

            ) {
            items(userList.orEmpty()) { user ->

                Display(user, navController)


            }

        }

    }
}

@Composable
fun Display(
    user: User,
    navController: NavController

) {

    Card(
        // when clicked move to update screen and get the id of item we selected
        modifier = Modifier.clickable {
            navController.navigate(
                route = "update/${user.id}/${user.firstName}/${user.lastName}/${user.age}"
            )
        },
        elevation = 0.dp, contentColor = if (isSystemInDarkTheme())
            dark
        else
            lightGray

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {


            Row(modifier = Modifier.width(60.dp)){
                Text(
                    text = "${user.firstName.first()}",
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    style = MaterialTheme.typography.h2,
                    color = if (isSystemInDarkTheme())
                        newDark
                    else
                        newGray


                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()

            ) {
                Text(
                    text = user.firstName,
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(start = 32.dp),
                    color = if (isSystemInDarkTheme())
                        newDark
                    else
                        Gray
                )
                Text(
                    text = user.lastName,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 8.dp),
                    color = if (isSystemInDarkTheme())
                        newDark
                    else
                        Gray
                )

                Text(
                    text = "${user.age}",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(start = 8.dp),
                    color = if (isSystemInDarkTheme())
                        newDark
                    else
                        Gray
                )
            }
        }

    }

}


@Composable
fun TopBar(clickable: () -> Unit) {
    TopAppBar(
        title = { Text(text = "List") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = null,
                modifier = Modifier.padding(start = 12.dp)
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Delete",
                modifier = Modifier.clickable { clickable() }
            )
        }

    )
}

@Composable
fun Floating(navController: NavController) {
    FloatingActionButton(
        onClick = { navController.navigate("addUser") },
        backgroundColor = if (isSystemInDarkTheme())
            Purple700
        else
            Teal200,
    ) {
        Icon(
            imageVector = Icons.Filled.Add, contentDescription = null,
            tint = if (isSystemInDarkTheme())
                Color.LightGray
            else
                Color.White,
        )
    }
}
