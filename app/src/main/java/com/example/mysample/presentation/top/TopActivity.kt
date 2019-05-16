package com.example.mysample.presentation.top

import android.animation.AnimatorInflater
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mysample.R
import com.example.mysample.databinding.ActivityTopBinding
import com.example.mysample.presentation.util.BaseActivity
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_top.view.*


class TopActivity : BaseActivity() {

    companion object {
        fun createIntent(context: Context): Intent {

            val intent = Intent(context, TopActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
            return intent

        }
    }

    private val binding: ActivityTopBinding by lazy {
        DataBindingUtil.setContentView<ActivityTopBinding>(this, R.layout.activity_top)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setNowActivity(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)


        val animatorSet = AnimatorInflater.loadAnimator(this, R.animator.repeat)
        animatorSet.setTarget(binding.root.speaker)
        animatorSet.start()
    }
}
