package com.uninter.demosandroid.todo.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ToDoViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ToDoViewModel::class.java)){
            return ToDoViewModel(application) as T
        }
        if(modelClass.isAssignableFrom(ToDoDetailViewModel::class.java)){
            return ToDoDetailViewModel(application) as T
        }

        throw IllegalArgumentException("Classe de viewmodel invalida")
    }
}