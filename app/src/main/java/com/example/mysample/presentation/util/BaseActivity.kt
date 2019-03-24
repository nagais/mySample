package com.example.mysample.presentation.util

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.example.mysample.util.helper.Navigator

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    fun setNowActivity(activity: BaseActivity) {
        Navigator.activity = activity
    }
}