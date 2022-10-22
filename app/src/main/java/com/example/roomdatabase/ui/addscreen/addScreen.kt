package com.example.roomdatabase.navigation

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import com.example.roomdatabase.viewmodel.TextViewModel

@Composable
fun AddUserUi(navController: NavController) {
    val max = 10
    val context = LocalContext.current
    val viewModel: UserViewModel = viewModel()

    // new value
    val viewModelState: TextViewModel = viewModel()
    val fName by viewModelState.fName.observeAsState(initial = "")
    val lName by viewModelState.lName.observeAsState(initial = "")
    val age by viewModelState.age.observeAsState(initial = "")

    Scaffold(
        topBar = { TopBar2(navController) },

        ) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
        ) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                InputFromUser(
                    fName = fName,
                    textFiled1 = {
                        val value = if (it.length <= max) it else ""
                        viewModelState.newFName(value)
                    },
                    lName = lName,
                    textFiled2 = {

                        val value = if (it.length <= max) it else ""
                        viewModelState.newLName(value)
                    },
                    age = age,
                    textFiled3 = {
                        val value = if (it.length <= 2) it else ""
                        viewModelState.newAge(value)

                    }
                )
                ButtonClick {
                    if (fName.isNotEmpty() && lName.isNotEmpty() && age.isNotEmpty()) {
                        viewModel.addUser(
                            User(
                                id = 0,
                                firstName = fName,
                                lastName = lName,
                                age = age.toInt()
                            )
                        )
                        Toast.makeText(context, "Successfully added!", Toast.LENGTH_LONG)
                            .show()
                        navController.navigate(route = "list")
                    } else {
                        Toast.makeText(context, "Please enter all information", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }

        }

    }
}

@Composable
fun ButtonClick(onClicked: () -> Unit) {
    Button(
        onClick = onClicked, modifier = Modifier
            .padding(16.dp)
            .width(400.dp)
    ) {
        Text(text = "Add", fontSize = 16.sp)
    }
}

@Composable
fun InputFromUser(
    fName: String,
    textFiled1: (String) -> Unit,
    lName: String,
    textFiled2: (String) -> Unit,
    age: String,
    textFiled3: (String) -> Unit
) {
    OutlinedTextField(
        value = fName, onValueChange = textFiled1,
        label = { Text(text = "First Name") },
        modifier = Modifier.padding(top = 64.dp),
        maxLines = 1,
    )
    OutlinedTextField(
        value = lName, onValueChange = textFiled2,
        label = { Text(text = "Last Name") },
        modifier = Modifier.padding(top = 16.dp),
        maxLines = 1,
    )
    OutlinedTextField(
        value = age, onValueChange = textFiled3,
        label = { Text(text = "Age") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        maxLines = 1,
        modifier = Modifier.padding(top = 16.dp)
    )
}

@Composable
fun TopBar2(navController: NavController) {
    TopAppBar(title = { Text(text = "add User") },
        navigationIcon = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Person",
                modifier = Modifier.clickable { navController.navigateUp() }
            )
        })
}