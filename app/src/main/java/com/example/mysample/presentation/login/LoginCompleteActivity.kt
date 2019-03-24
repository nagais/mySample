package com.example.mysample.presentation.login

import android.net.Uri
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.data.EncryptSharedPreferences
import com.example.mysample.databinding.ActivityLoginCompleteBinding
import com.example.mysample.presentation.util.BaseActivity
import com.example.mysample.util.crypt.EncodeKeyList
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginCompleteActivity : BaseActivity() {

    val binding: ActivityLoginCompleteBinding by lazy {
        DataBindingUtil.setContentView<ActivityLoginCompleteBinding>(this, R.layout.activity_login_complete)
    }

    @Inject
    lateinit var viewModel: LoginCompleteViewModel

    @Inject
    lateinit var encPreferences: EncryptSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setNowActivity(this)

        super.onCreate(savedInstanceState)

        val uri = Uri.parse(intent.dataString)
        val code = uri.getQueryParameter(EncodeKeyList.KEY_CODE) ?: ""
        encPreferences.save(EncodeKeyList.KEY_CODE, code)
        viewModel.start()
    }
}
