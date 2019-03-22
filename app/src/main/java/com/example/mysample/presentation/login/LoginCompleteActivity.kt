package com.example.mysample.presentation.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.databinding.ActivityLoginCompleteBinding
import dagger.android.AndroidInjection

class LoginCompleteActivity : AppCompatActivity() {

    val binding: ActivityLoginCompleteBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginCompleteBinding>(this, R.layout.activity_login_complete)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
    }
}
