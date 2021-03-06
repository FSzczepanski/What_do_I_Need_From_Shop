package com.example.whatdoineedfromshop

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.whatdoineedfromshop.ui.FragmentMostNeeded
import com.example.whatdoineedfromshop.ui.FragmentNeededInFuture

class MyAdapter(private val myContext: Context, fm: FragmentManager, internal var totalTabs: Int) : FragmentPagerAdapter(fm) {

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                //  val homeFragment: HomeFragment = HomeFragment()
                return FragmentMostNeeded()
            }
            1 -> {
                return FragmentNeededInFuture()
            }
            else -> return Fragment()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}