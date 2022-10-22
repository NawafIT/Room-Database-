package com.example.roomdatabase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel() {
    val fName = MutableLiveData("")
    val lName = MutableLiveData("")
    val age = MutableLiveData("")
    val confirm = MutableLiveData(true)


    fun newFName(newFName: String) {

        fName.value = newFName
    }

    fun newLName(newLName: String) {
        lName.value = newLName
    }

    fun newAge(newAge: String) {
        age.value = newAge
    }

    fun newConfirm(newConfirm: Boolean) {
        confirm.value = newConfirm
    }

}