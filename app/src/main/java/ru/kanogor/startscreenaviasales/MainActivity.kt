package ru.kanogor.startscreenaviasales

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import ru.kanogor.startscreenaviasales.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                    as NavHostFragment

        binding.bottomNavView.setupWithNavController(navController.navController)
        binding.bottomNavView.setOnItemSelectedListener { item ->
            Log.d("ItemIdLog", "item id = ${item.itemId}")
            when (item.itemId) {
                R.id.airticketsFragment -> navigateTo("android-app:/aviasales")
                R.id.hotelsFragment -> navigateTo("android-app:/hotelsFrag")
                R.id.simplyFragment -> navigateTo("android-app:/simply")
                R.id.bellFragment -> navigateTo("android-app:/bell")
                R.id.profileFragment -> navigateTo("android-app:/profile")
                else -> navigateTo("android-app:/aviasales")
            }
            true
        }
    }

    private fun navigateTo(uri: String) {
        val request = NavDeepLinkRequest.Builder
            .fromUri(uri.toUri())
            .build()
        findNavController(R.id.nav_host_fragment).navigate(request)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}