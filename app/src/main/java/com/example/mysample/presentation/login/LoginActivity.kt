package com.example.mysample.presentation.login

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.databinding.ActivityLoginBinding
import com.example.mysample.util.env.EnvConfig
import dagger.android.AndroidInjection


class LoginActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        fun createIntent(context: Context): Intent = Intent(context, LoginActivity::class.java)
    }

    private val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(EnvConfig.QIITA_OAUTH_URL))
        startActivity(intent)
    }
}
