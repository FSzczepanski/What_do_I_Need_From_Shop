package com.example.whatdoineedfromshop.ui

import com.example.whatdoineedfromshop.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item:ShoppingItem)
}