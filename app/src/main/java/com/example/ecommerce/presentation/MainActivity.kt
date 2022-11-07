package com.example.ecommerce.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ActivityMainBinding
import com.example.ecommerce.presentation.cart.CartFragment
import com.example.ecommerce.presentation.explorer.ExplorerFragment
import com.example.ecommerce.presentation.favorites.FavoritesFragment
import com.example.ecommerce.presentation.profile.ProfileFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding.bottomNavigationView) {
            setItemSelected(R.id.explorer)
            replaceFragment(ExplorerFragment())
            setOnItemSelectedListener { id ->
                when (id) {
                    R.id.explorer -> replaceFragment(ExplorerFragment())
                    R.id.profile -> replaceFragment(ProfileFragment())
                    R.id.favorites -> replaceFragment(FavoritesFragment())
                    R.id.cart -> replaceFragment(CartFragment())
                }
            }
        }
    }

    override fun onBackPressed() {
        if (binding.bottomNavigationView.getSelectedItemId() == R.id.explorer) {
            super.onBackPressed()
        } else {
            binding.bottomNavigationView.setItemSelected(R.id.explorer)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment is ExplorerFragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment).commit()
        }
    }
}