package com.example.whatdoineedfromshop.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.whatdoineedfromshop.data.db.entities.ShoppingItem
import com.example.whatdoineedfromshop.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FragmentNeededInFutureViewModel(
    private val repository: ShoppingRepository,
    application: Application
):ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.upsert(item)}

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch{
        repository.delete(item)}

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}
