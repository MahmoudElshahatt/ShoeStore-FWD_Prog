package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val nav_controller = this.findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(nav_controller.graph)
        NavigationUI.setupActionBarWithNavController(this, nav_controller)

    }

    override fun onSupportNavigateUp(): Boolean {
        val nav_controller = this.findNavController(R.id.nav_host_fragment)
        if (nav_controller.currentDestination?.id == R.id.addShoeFragment) {
            Toast.makeText(applicationContext, "Shoe is not saved !! ", Toast.LENGTH_SHORT).show()
        }
        return NavigationUI.navigateUp(
            nav_controller,
            appBarConfiguration
        ) || super.onSupportNavigateUp()

    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }
}
