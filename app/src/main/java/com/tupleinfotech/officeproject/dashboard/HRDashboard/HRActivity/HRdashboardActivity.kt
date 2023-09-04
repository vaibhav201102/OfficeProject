package com.tupleinfotech.officeproject.dashboard.HRDashboard.HRActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tupleinfotech.officeproject.databinding.ActivityHrdashboardBinding

class HRdashboardActivity : AppCompatActivity() {

    private var _binding : ActivityHrdashboardBinding?= null
    private val binding get() =  _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHrdashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}