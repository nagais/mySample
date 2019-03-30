package com.example.mysample.util.di

import com.example.mysample.data.api.QiitaApi
import com.example.mysample.data.repository.qiita.QiitaRepository
import com.example.mysample.domain.repository.QiitaRepositoryInterface
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideQiitaRepositoryInterface(qiitaApi: QiitaApi): QiitaRepositoryInterface {
        return QiitaRepository(qiitaApi)
    }

}