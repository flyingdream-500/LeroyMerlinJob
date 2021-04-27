package com.example.leroymerlinjob

import android.graphics.Rect
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bnv_main, navController)

        hideBottomViewUnderKeyboard()

    }

    //Костылище
    //Прячем BottomNavigationView под клавиатуру
    private fun hideBottomViewUnderKeyboard() {
        rl_main.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            rl_main.getWindowVisibleDisplayFrame(r)
            val screenHeight = rl_main.rootView.height
            val keypadHeight = screenHeight - r.bottom
            if (keypadHeight > screenHeight * 0.15) {
                bnv_main.visibility = View.GONE
            } else {
                bnv_main.post{ bnv_main.visibility = View.VISIBLE }
            }
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, navController)
        return super.onOptionsItemSelected(item)
    }
}