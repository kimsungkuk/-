package com.example.homework

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homework.fragment.FavoriteFragment
import com.example.homework.fragment.HomeFragment
import com.example.homework.fragment.ProfileFragment
import com.example.homework.fragment.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val bn: BottomNavigationView by lazy { findViewById(R.id.bottomNavigationView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavigationBar()

    }

    private fun initNavigationBar() {

        bn.run {
            setOnItemSelectedListener { item ->
                changeFragment(
                    when (item.itemId) {
                        R.id.tab_home -> HomeFragment()
                        R.id.tab_search -> SearchFragment()
                        R.id.tab_favorite -> FavoriteFragment()
                        else -> ProfileFragment()
                    }
                )
                true
            }
            selectedItemId = R.id.tab_favorite
        }

    }


    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
            .commit()
    }


}