package com.example.mysample.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.databinding.ActivityLoginBinding
import dagger.android.AndroidInjection

class LoginActivity : AppCompatActivity() {

    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
