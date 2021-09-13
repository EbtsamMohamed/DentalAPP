package com.example.ebtsamdemo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ebtsamdemo1.databinding.ActivityMainBinding
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.regex.Pattern.compile

public class MainActivity : AppCompatActivity() {
    //Global references
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {

            if (validate()) {
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()
                /* var intent: Intent = Intent(this, MainActivity::class.java)
                 startActivity(intent)*/
            }
        }
        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                binding.edtPassword.inputType = 1
            } else
                binding.edtPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString())
                        .matches()
                )
                    binding.btnSignup.isEnabled = true
                else {
                    binding.btnSignup.isEnabled = false
                    binding.edtEmail.setError("Invalid Email")
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.edtPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (mobileValidate(binding.edtPhone.text.toString()))
                    binding.btnSignup.isEnabled = true
                else {
                    binding.btnSignup.isEnabled = false
                    binding.edtPhone.setError("Invalid Phone Number")
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }

    private fun mobileValidate(text: String): Boolean {
        var p: Pattern = Pattern.compile("[1][0-9]{9}")
        var m: Matcher = p.matcher(text)
        return m.matches()
    }

    private fun validate(): Boolean {
        if (binding.edtFullname.text.toString().isEmpty()) {
            binding.edtFullname.error = "UserName Required"
            return false
        } else if (binding.edtEmail.text.toString().isEmpty()) {
            binding.edtEmail.error = "Email Required"
            return false
        } else if (binding.edtPhone.text.toString().isEmpty()) {
            binding.edtPhone.error = "Phone Number Required"
            return false
        } else if (binding.edtPassword.text.toString().isEmpty()) {
            binding.edtPassword.error = "Password Required"
            return false
        }
        return true
    }


}






