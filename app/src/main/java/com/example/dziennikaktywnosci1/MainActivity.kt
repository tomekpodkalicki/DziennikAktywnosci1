package com.example.dziennikaktywnosci1

import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.dziennikaktywnosci1.data.models.Transaction
import com.example.dziennikaktywnosci1.data.models.TransactionCategory
import com.example.dziennikaktywnosci1.data.models.TransactionType
import com.example.dziennikaktywnosci1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val mainVm by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding
        private lateinit var navController: NavController

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment
            navController = navHostFragment.navController
            NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
            mainVm.insertTransaction(createTransaction())


        }
    private fun createTransaction() = Transaction(0,1L,
        15, "opis", TransactionType.INCOME, TransactionCategory.TRANSPORTATION)
    }
