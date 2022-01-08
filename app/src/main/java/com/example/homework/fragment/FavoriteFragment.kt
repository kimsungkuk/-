package com.example.homework.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.homework.MainActivityViewModel
import com.example.homework.PagerFragmentStateAdapter
import com.example.homework.R
import com.example.homework.RecyclerViewAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_favorite.*


class FavoriteFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewpager2: ViewPager2

    val tabLayoutTextArray = arrayOf("저장","최근본")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewpager2 = view.findViewById(R.id.viewpager2)

        viewpager2.adapter = ViewPagerAdapter(requireActivity())
        viewpager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })

        TabLayoutMediator(tabLayout,viewpager2){tab,position->
            tab.text = tabLayoutTextArray[position]
        }.attach()


    }

    private inner class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa){
        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> FavoriteDetailFragment()
                else -> RecentFragment()
            }
        }
        override fun getItemCount():Int = 2
    }


}