package com.etisalat.itworx.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etisalat.googleassis.R
import com.example.googleassistant.ProfileActivity
import com.example.googleassistant.SettingsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent.handleIntent()
    }

    private fun Intent.handleIntent(){
        when(action){
            Intent.ACTION_VIEW -> handleDeepLink(data)
            else -> gotoDefaultView()
        }
    }

    private fun handleDeepLink(data: Uri?) {
       when(data?.path)
       {
         "/open" -> {
             val featureType = data.getQueryParameter("featureType").orEmpty()
             navigatetoActivity(featureType)
         }
       }
    }

    private fun navigatetoActivity(featureType: String) {
        when(featureType)
        {
            "profile" -> {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivity(profileIntent)
            }
            "settings" -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }

    }

    private fun gotoDefaultView() {
        TODO("Not yet implemented")
    }
}