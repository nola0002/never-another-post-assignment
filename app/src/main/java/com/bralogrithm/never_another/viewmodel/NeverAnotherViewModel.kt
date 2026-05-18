package com.bralogrithm.never_another.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.bralogrithm.never_another.model.Screen

class NeverAnotherViewModel: ViewModel() {

    var selectedScreen by mutableStateOf(Screen.Home)

}