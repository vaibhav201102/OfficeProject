package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.ActivityHrdashboardBinding

class HRdashboardActivity : AppCompatActivity() {

    private var _binding : ActivityHrdashboardBinding?= null
    private val binding get() =  _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHrdashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container_hr_view_data) as NavHostFragment
        navController = navHostFragment.navController

        bottomnavigationfuctionality()
    }

    private fun bottomnavigationfuctionality(){

        binding.hrBottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_dashboard_hr -> {
                    navController.navigate(R.id.hrhomeFragment)
                }
                R.id.bottom_attendance_hr -> {
                    navController.navigate(R.id.HRWorksheetFragment)
                }
                R.id.bottom_Menu3_hr -> {
//                    navController.navigate(R.id.HRLeaveManagementFragment)
                }
                R.id.bottom_noticeboard_hr -> {
                    navController.navigate(R.id.HRnoticeBoardFragment)
                }
                R.id.bottom_profile_hr -> {
                    navController.navigate(R.id.HrProfileDetailsFragment)
                }
                else -> {

                }
            }
            true
        }
    }
}