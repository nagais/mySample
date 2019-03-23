package com.example.mysample.data.repository.qiita

import com.squareup.moshi.Json

class AccessTokenQueryParameter {

    @field:Json(name = "client_id")
    var clientId: String? = null
    @field:Json(name = "client_secret")
    var clientSecret: String? = null
    @field:Json(name = "code")
    var code: String? = null
}