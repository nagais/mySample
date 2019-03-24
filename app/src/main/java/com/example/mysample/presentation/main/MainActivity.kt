package com.example.mysample.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mysample.R
import com.example.mysample.data.EncryptSharedPreferences
import com.example.mysample.presentation.util.BaseActivity
import com.example.mysample.util.crypt.EncodeKeyList
import com.example.mysample.util.helper.Navigator
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var encPreferences: EncryptSharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setNowActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val token: String? = encPreferences.get(EncodeKeyList.KEY_QIITA_TOKEN)
        if (token == null) {
            Navigator.navigateLoginActivity()
        } else {
            Navigator.navigateTopActivity()
        }
    }
}
