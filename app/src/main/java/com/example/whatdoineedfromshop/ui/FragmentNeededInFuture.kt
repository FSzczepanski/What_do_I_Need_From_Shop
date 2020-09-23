package com.example.whatdoineedfromshop.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.whatdoineedfromshop.R

class FragmentNeededInFuture : Fragment() {

    companion object {
        fun newInstance() = FragmentNeededInFuture()
    }

    private lateinit var viewModel: FragmentNeededInFutureViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_needed_in_future_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentNeededInFutureViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
