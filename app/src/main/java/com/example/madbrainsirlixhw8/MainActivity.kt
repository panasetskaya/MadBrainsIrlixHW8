package com.example.madbrainsirlixhw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.madbrainsirlixhw8.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
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
                    Log.i("MyResult","")
                }
            })

        }
    }
}