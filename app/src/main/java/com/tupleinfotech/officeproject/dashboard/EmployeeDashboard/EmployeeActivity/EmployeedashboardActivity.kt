package com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.ActivityEmployeedashboardBinding

class EmployeedashboardActivity : AppCompatActivity() {

    private var _binding : ActivityEmployeedashboardBinding?= null
    private val binding get() =  _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityEmployeedashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container_view_data) as NavHostFragment
        navController = navHostFragment.navController
        bottomnavigationfuctionality()

    }

    private fun bottomnavigationfuctionality(){

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_dashboard_emp -> {
                    navController.navigate(R.id.homeFragment)
                }
                R.id.bottom_attendance_emp -> {
                    navController.navigate(R.id.worksheetFragment)
                }
                R.id.bottom_noticeboard_emp -> {
                    //navController.navigate(R.id.wishlistFragment)
                }
                R.id.bottom_profile_emp -> {
                    //navController.navigate(R.id.cartFragment)
                }
                else -> {

                }
            }
            true
        }
    }
}