package com.example.mysample.data.repository.qiita

import com.example.mysample.data.api.QiitaApi
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.repository.QiitaAccessTokenRepositoryInterface
import io.reactivex.Single
import javax.inject.Inject

class QiitaAccessTokenRepository @Inject constructor(private val qiitaApi: QiitaApi)
    : QiitaAccessTokenRepositoryInterface {

    override fun getAccessToken(parameter: AccessTokenQueryParameter): Single<AccessTokenAggregate> {
        return qiitaApi.getAccessTokens(parameter)
    }
}