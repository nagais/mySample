package com.example.mysample.data.repository.qiita

import com.example.mysample.data.api.QiitaApi
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.repository.QiitaRepositoryInterface
import io.reactivex.Single
import javax.inject.Inject

class QiitaRepository @Inject constructor(private val qiitaApi: QiitaApi) :
    QiitaRepositoryInterface {

    override fun getAccessToken(parameter: AccessTokenQueryParameter): Single<AccessTokenAggregate> {
        return qiitaApi.getAccessTokens(parameter)
    }
}