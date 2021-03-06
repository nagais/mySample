package com.example.mysample.presentation

import android.app.Activity
import android.app.Application
import com.example.mysample.util.di.AppModule
import com.example.mysample.util.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Reference
 * https://medium.com/@star_zero/dagger-android%E6%8B%A1%E5%BC%B5%E3%81%AE%E4%BD%BF%E3%81%84%E6%96%B9-6527dcb74531
 */
class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .create(this)
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}