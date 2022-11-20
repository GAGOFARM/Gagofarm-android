package com.foo.gagofarm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class LoginActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginBtn : Button = findViewById(R.id.loginButton)
        loginBtn.setOnClickListener{ view ->
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        var signUpBtn : Button = findViewById(R.id.signUpButton)
        signUpBtn.setOnClickListener{ view ->
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }

    }
}