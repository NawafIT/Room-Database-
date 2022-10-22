//package com.example.roomdatabase.ui.deletescreen
//
//
//import android.widget.Toast
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import com.example.roomdatabase.data.User
//import com.example.roomdatabase.data.UserViewModel
//
//@Composable
//fun UpdateUser(navController: NavController, id: Int?) {
//    val context = LocalContext.current
//    val viewModel: UserViewModel = viewModel()
//    var fName by remember { mutableStateOf("") }
//    var lName by remember { mutableStateOf("") }
//    var age by remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = { TopBar2(navController) },
//
//        ) { paddingValues ->
//        Surface(
//            modifier = Modifier
//                .padding(paddingValues)
//                .fillMaxSize(),
//        ) {
//
//            Column(
//                verticalArrangement = Arrangement.Top,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(16.dp)
//            ) {
//                InputFromUser(fName = fName, textFiled1 = { fName = it },
//                    lName = lName, textFiled2 = { lName = it },
//                    age = age, textFiled3 = { age = it }
//                )
//                ButtonClick {
//                    if (fName.isNotEmpty() && lName.isNotEmpty() && age.isNotEmpty()) {
//                        viewModel.updateUser(
//                            User(
//                                id = id!!,
//                                firstName = fName,
//                                lastName = lName,
//                                age = age.toInt()
//                            )
//                        )
//                        Toast.makeText(context, "Successfully updated!", Toast.LENGTH_LONG)
//                            .show()
//                        navController.navigate(route = "list")
//                    } else {
//                        Toast.makeText(context, "Please enter all information", Toast.LENGTH_LONG)
//                            .show()
//                    }
//                }
//            }
//
//        }
//
//    }
//}
//
//@Composable
//fun ButtonClick(onClicked: () -> Unit) {
//    Button(
//        onClick = onClicked, modifier = Modifier
//            .padding(16.dp)
//            .width(400.dp)
//    ) {
//        Text(text = "Update", fontSize = 16.sp)
//    }
//}
//
//@Composable
//fun InputFromUser(
//    fName: String,
//    textFiled1: (String) -> Unit,
//    lName: String,
//    textFiled2: (String) -> Unit,
//    age: String,
//    textFiled3: (String) -> Unit
//) {
//    OutlinedTextField(
//        value = fName, onValueChange = textFiled1,
//        label = { Text(text = "First Name") },
//        modifier = Modifier.padding(top = 64.dp),
//        maxLines = 1,
//    )
//    OutlinedTextField(
//        value = lName, onValueChange = textFiled2,
//        label = { Text(text = "Last Name") },
//        modifier = Modifier.padding(top = 16.dp),
//        maxLines = 1,
//    )
//    OutlinedTextField(
//        value = age, onValueChange = textFiled3,
//        label = { Text(text = "Age") },
//        keyboardOptions = KeyboardOptions(
//            keyboardType = KeyboardType.Number
//        ),
//        maxLines = 1,
//        modifier = Modifier.padding(top = 16.dp)
//    )
//}
//
//@Composable
//fun TopBar2(navController: NavController) {
//    TopAppBar(title = { Text(text = "Update User") },
//        navigationIcon = {
//            Icon(
//                imageVector = Icons.Filled.ArrowBack,
//                contentDescription = "Person",
//                modifier = Modifier.clickable { navController.navigateUp() }
//            )
//        })
//}