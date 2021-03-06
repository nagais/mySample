package com.example.mysample.domain.repository

import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import io.reactivex.Single

interface QiitaRepositoryInterface {

    fun getAccessToken(parameter: AccessTokenQueryParameter): Single<AccessTokenAggregate>
}