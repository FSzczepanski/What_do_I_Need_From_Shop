package com.example.whatdoineedfromshop.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatdoineedfromshop.data.repositories.ShoppingRepository

class FragmentNeededInFutureViewModelFactory (private val repository: ShoppingRepository, application: Application
): ViewModelProvider.AndroidViewModelFactory(application) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentNeededInFutureViewModel(repository,application = Application()) as T
    }
}