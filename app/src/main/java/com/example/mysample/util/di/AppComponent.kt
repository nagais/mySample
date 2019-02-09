package com.example.mysample.util.di

import com.example.mysample.presentation.MyApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    // AndroidInjector.Builderをそのまま使ってる
    //   @BindsInstanceによってAppクラスを依存解決できるようになってる
    //   createメソッドが定義されている
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<MyApplication>()
}
