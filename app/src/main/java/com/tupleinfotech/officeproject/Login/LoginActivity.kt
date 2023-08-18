package com.tupleinfotech.officeproject.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tupleinfotech.officeproject.dashboard.AdminDashboard.AdminActivity.AdmindashboardActivity
import com.tupleinfotech.officeproject.dashboard.EmployeeDashboard.EmployeeActivity.EmployeedashboardActivity
import com.tupleinfotech.officeproject.dashboard.HRDashboard.HRActivity.HRdashboardActivity
import com.tupleinfotech.officeproject.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var _binding : ActivityLoginBinding?= null
    private val binding get() =  _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // navigation to dashboard HR, Admin and Employee
        // after login service

        //LoginbuttonClickevent("ADMIN")
        LoginbuttonClickevent("EMPLOYEE")
        //LoginbuttonClickevent("HR")

    }

    private fun LoginbuttonClickevent(type:String){

        var intent : Intent

        binding.loginBtn.setOnClickListener{
            when(type){
                "EMPLOYEE" -> {
                    intent = Intent(this@LoginActivity, EmployeedashboardActivity::class.java)
                    startActivity(intent)
                }
                "HR" ->{
                    intent = Intent(this@LoginActivity, HRdashboardActivity::class.java)
                    startActivity(intent)
                }
                "ADMIN" -> {
                    intent = Intent(this@LoginActivity, AdmindashboardActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}