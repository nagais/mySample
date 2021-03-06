package com.example.mysample.presentation.top

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.mysample.R
import com.example.mysample.presentation.util.BaseActivity
import dagger.android.AndroidInjection


class TopActivity : BaseActivity() {

    companion object {
        fun createIntent(context: Context): Intent {

            val intent = Intent(context, TopActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            return intent

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setNowActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)
    }
}
