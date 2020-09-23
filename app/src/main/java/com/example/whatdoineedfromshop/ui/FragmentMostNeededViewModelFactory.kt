package com.example.whatdoineedfromshop.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatdoineedfromshop.data.repositories.ShoppingRepository

class FragmentMostNeededViewModelFactory(
    private val repository: ShoppingRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FragmentMostNeededViewModel(repository) as T
    }
}