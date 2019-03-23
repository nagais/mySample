package com.example.mysample.util.di

import android.content.Context
import android.preference.PreferenceManager
import com.example.mysample.data.EncryptSharedPreferences
import com.example.mysample.data.api.QiitaApi
import com.example.mysample.presentation.MyApplication
import com.example.mysample.util.env.EnvConfig
import com.example.mysample.util.net.AppJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class AppModule {

    private val loggingInterceptor = HttpLoggingInterceptor()

    @Singleton
    @Provides
    fun provideContext(application: MyApplication): Context {
        return application.applicationContext
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(AppJsonAdapterFactory.INSTANCE)
            .build()
    }

    @Singleton
    @Provides
    fun provideEncryptSharedPreferences(context: Context): EncryptSharedPreferences {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return EncryptSharedPreferences(preferences)
    }

    @Provides
    fun provideHttpClient(): OkHttpClient.Builder {

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(Interceptor { chain ->
                val original = chain.request()

                val request = original.newBuilder()
                    .header("Accept", "application/json")
                    .method(original.method(), original.body())
                    .build()

                return@Interceptor chain.proceed(request)
            })
            .readTimeout(30, TimeUnit.SECONDS)

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(loggingInterceptor)

        return httpClient
    }

    @Provides
    fun provideQiitaApi(httpClient: OkHttpClient, moshi: Moshi): QiitaApi {
        return Retrofit.Builder()
            .client(httpClient)
            .baseUrl(EnvConfig.QIITA_API_BASE)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(QiitaApi::class.java)
    }
}