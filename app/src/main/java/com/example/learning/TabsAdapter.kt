package com.example.learning

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.learning.tab2.Tab2Fragment
import com.example.learning.todo.TodoFragment

class TabsAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return TodoFragment()
            1 -> return Tab2Fragment()
        }
        return Tab2Fragment()
    }
}