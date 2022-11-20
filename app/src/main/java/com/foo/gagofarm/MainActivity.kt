package com.foo.gagofarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import com.foo.gagofarm.databinding.ActivityMainBinding
import com.foo.gagofarm.fragments.BookmarkFragment
import com.foo.gagofarm.fragments.MessageFragment
import com.foo.gagofarm.fragments.SearchFragment

class MainActivity : AppCompatActivity(){
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val transaction = supportFragmentManager.beginTransaction()

        transaction.add(R.id.frameLayout,SearchFragment())
        transaction.commit()

        val searchFragment = SearchFragment()
        val bookmarkFragment = BookmarkFragment()
        val messageFragment = MessageFragment()
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.search->replaceFragment(searchFragment)
                R.id.bookmark->replaceFragment(bookmarkFragment)
                R.id.message->replaceFragment(messageFragment)
            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment) {
        Log.d("ssss","sendfff")
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}