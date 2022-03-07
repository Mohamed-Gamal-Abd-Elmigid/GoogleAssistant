package com.etisalat.itworx.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.etisalat.itworx.activity.R
import com.etisalat.itworx.activity.ProfileActivity
import com.etisalat.itworx.activity.SettingsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent.handleIntent()
    }

    private fun Intent.handleIntent() {
        when (action) {
            Intent.ACTION_VIEW -> handleDeepLink(data)
            else -> gotoDefaultView()
        }
    }

    private fun handleDeepLink(data: Uri?) {
        Log.d("ttttttt ","Data  = " + data.toString() )
        when (data?.path) {
            "/open" -> {
                val featureType = data.getQueryParameter("featureName").orEmpty()
                navigatetoActivity(featureType)
            }
        }
    }

    private fun navigatetoActivity(featureType: String) {
        Log.d("ttttttt ","featureType  = " + featureType )

        when {
            featureType.contains("profile",true) ->  {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                 startActivity(profileIntent)
            }

            featureType.contains("settings",true) -> {
                val settingsIntent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }

    }

    private fun gotoDefaultView() {
//        TODO("Not yet implemented")
    }
}