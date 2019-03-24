package com.example.mysample.util.helper

import androidx.appcompat.app.AppCompatActivity
import com.example.mysample.presentation.login.LoginActivity
import com.example.mysample.presentation.top.TopActivity


object Navigator {

    var activity: AppCompatActivity = AppCompatActivity()

    fun navigateLoginActivity() {
        activity.startActivity(LoginActivity.createIntent(activity))
    }

    fun navigateTopActivity() {
        activity.startActivity(TopActivity.createIntent(activity))
    }
}
