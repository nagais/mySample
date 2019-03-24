package com.example.mysample.data.api

import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface QiitaApi {

    @POST("api/v2/access_tokens")
    fun getAccessTokens(@Body body: AccessTokenQueryParameter): Single<AccessTokenAggregate>
}