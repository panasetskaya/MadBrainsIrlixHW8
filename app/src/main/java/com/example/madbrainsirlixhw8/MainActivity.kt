package com.example.madbrainsirlixhw8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
                    Log.i("MyResult","fetching token failed", it.exception)
                    return@OnCompleteListener
                }
                val token = it.result
                Log.d("TAG1" ,token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun checkGooglePlayServices() {
        TODO("Not yet implemented")
    }

    private fun createNotificationChannel() {
        TODO("Not yet implemented")
    }
}