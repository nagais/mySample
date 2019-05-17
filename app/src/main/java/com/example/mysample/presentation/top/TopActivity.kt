package com.example.mysample.presentation.top

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysample.R
import com.example.mysample.databinding.ActivityTopBinding
import com.example.mysample.presentation.util.BaseActivity
import dagger.android.AndroidInjection
import javax.inject.Inject


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

    @Inject
    lateinit var viewModel: TopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        setNowActivity(this)
        super.onCreate(savedInstanceState)

        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.recyclerView.also { recyclerView ->
            recyclerView.adapter = viewModel.topContentAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.setHasFixedSize(true)
        }
    }
}
