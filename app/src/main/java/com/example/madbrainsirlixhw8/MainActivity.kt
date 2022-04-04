package com.example.madbrainsirlixhw8

import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.madbrainsirlixhw8.databinding.ActivityMainBinding
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "1"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createNotificationChannel()

        binding.button.setOnClickListener {
            checkGooglePlayServices()
            FirebaseMessaging.getInstance().token.addOnCompleteListener( OnCompleteListener{
                if (!it.isSuccessful) {
                    Log.i("MyResult","fetching token failed", it.exception)
                    return@OnCompleteListener
                }
                val token = it.result
                Log.d("TAG1" ,token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun checkGooglePlayServices(): Boolean {
        val status = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this)
        return if (status!=ConnectionResult.SUCCESS) {
            Log.i("TAG1", "Error")
            false
        } else {
            Log.i("TAG1", "Google Play Services updated")
            true
        }
    }

    private fun createNotificationChannel() {
        val name = "My Gorgeous Channel"
        val descriptionText = "My gorgeous description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(CHANNEL_ID,name,importance).apply {
            description = descriptionText
        }
        val notificationManager: NotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)

    }
}