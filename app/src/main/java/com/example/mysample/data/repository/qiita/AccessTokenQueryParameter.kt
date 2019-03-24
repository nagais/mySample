package com.example.mysample.data.repository.qiita

import com.squareup.moshi.Json

data class AccessTokenQueryParameter(

    @Json(name = "client_id")
    var clientId: String? = null,
    @Json(name = "client_secret")
    var clientSecret: String? = null,
    @Json(name = "code")
    var code: String? = null
)
