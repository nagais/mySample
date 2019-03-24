package com.example.mysample.util.di

import com.example.mysample.presentation.login.LoginActivity
import com.example.mysample.presentation.login.LoginCompleteActivity
import com.example.mysample.presentation.main.MainActivity
import com.example.mysample.presentation.top.TopActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginCompleteActivity(): LoginCompleteActivity

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeTopActivity(): TopActivity
}