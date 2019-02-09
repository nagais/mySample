package com.example.mysample.util.di

import android.content.Context
import com.example.mysample.presentation.MyApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: MyApplication): Context {
        return application.applicationContext
    }
}