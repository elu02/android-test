package com.example.learning

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class TabsFragment : Fragment() {

    private lateinit var tabsAdapter: TabsAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tabs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabsAdapter = TabsAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = tabsAdapter

        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        //tabLayout.bringToFront()
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "List Maker"
                1 -> tab.text = "Tab 2"
            }
        }.attach()

    }
}