package com.example.mysample.presentation.login

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.databinding.ActivityLoginCompleteBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginCompleteActivity : AppCompatActivity() {

    companion object {
        private const val CODE_KEY = "code"
    }

    val binding: ActivityLoginCompleteBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginCompleteBinding>(this, R.layout.activity_login_complete)
    }

    @Inject
    lateinit var viewModel: LoginCompleteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)

        val uri = Uri.parse(intent.dataString)
        val code = uri.getQueryParameter(CODE_KEY)
        viewModel.start(code)
    }
}
