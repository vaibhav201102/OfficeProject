package com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.ActivityAdmindashboardBinding

class AdmindashboardActivity : AppCompatActivity() {

    private var _binding : ActivityAdmindashboardBinding?= null
    private val binding get() =  _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAdmindashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =supportFragmentManager.findFragmentById(R.id.fragment_container_hr_view_data) as NavHostFragment
        navController = navHostFragment.navController

        bottomnavigationfuctionality()
    }
    private fun bottomnavigationfuctionality(){

        binding.adminBottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_dashboard_admin -> {
                    navController.navigate(R.id.adminHomeFragment)
                }
                R.id.bottom_attendance_admin -> {
//                    navController.navigate(R.id.worksheetFragment)
                }
                R.id.bottom_Menu3_admin -> {
//                    navController.navigate(R.id.leaveFragment)
                }
                R.id.bottom_noticeboard_admin -> {
//                    navController.navigate(R.id.profileDetailsFragment)
                }
                R.id.bottom_profile_admin -> {
                    navController.navigate(R.id.adminprofiledetailsfragment)
                }
                else -> {

                }
            }
            true
        }
    }
}