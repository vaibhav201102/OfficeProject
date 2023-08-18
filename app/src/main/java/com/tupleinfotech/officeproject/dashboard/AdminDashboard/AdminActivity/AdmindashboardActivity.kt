package com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tupleinfotech.officeproject.R
import com.tupleinfotech.officeproject.databinding.ActivityAdmindashboardBinding
import com.tupleinfotech.officeproject.databinding.ActivityLoginBinding

class AdmindashboardActivity : AppCompatActivity() {

    private var _binding : ActivityAdmindashboardBinding?= null
    private val binding get() =  _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityAdmindashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}