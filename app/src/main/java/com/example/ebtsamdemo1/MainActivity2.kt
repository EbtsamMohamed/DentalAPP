package com.example.ebtsamdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import com.example.ebtsamdemo1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    //Global references
    lateinit var binding: ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {
            Toast.makeText(this, "Welcome!", Toast.LENGTH_LONG).show()
            var intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


}



