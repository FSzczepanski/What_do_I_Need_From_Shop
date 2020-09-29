package com.example.whatdoineedfromshop.ui

import android.app.Application
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.whatdoineedfromshop.R
import com.example.whatdoineedfromshop.data.db.ShoppingDatabase
import com.example.whatdoineedfromshop.data.db.entities.ShoppingItem
import com.example.whatdoineedfromshop.data.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.fragment_needed_in_future_fragment.*
import java.util.*

class FragmentNeededInFuture : Fragment() {

    companion object {
        fun newInstance() = FragmentNeededInFuture()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_needed_in_future_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val database = activity?.let { ShoppingDatabase(it) }
        val repository = database?.let { ShoppingRepository(it) }
        val factory = repository?.let { FragmentNeededInFutureViewModelFactory(it, Application()) }

        val viewModel: FragmentNeededInFutureViewModel by lazy {
            return@lazy when {
                activity != null -> {
                    ViewModelProvider(
                        activity as FragmentActivity,
                        factory as ViewModelProvider.Factory
                    ).get(FragmentNeededInFutureViewModel::class.java)
                }
                else -> {
                    ViewModelProviders.of(this).get(FragmentNeededInFutureViewModel::class.java)
                }
            }
        }

        val adapter = FragmentNeededInFutureItemAdapter(LinkedList<ShoppingItem>(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(context)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            var list: List<ShoppingItem> = it
            val list2 = LinkedList<ShoppingItem>()

            for(element in list){
                if (element.name[0].toString()=="F"){
                    list2.add(element)
                }


            }
            adapter.items = list2
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            activity?.let { it1 ->
                AddShoppingItemDialogNeededInFuture(
                    it1,
                    object : AddDialogListener {
                        override fun onAddButtonClicked(item: ShoppingItem) {
                            viewModel.upsert(item)
                        }

                    }).show()
            }
        }
    }

}
