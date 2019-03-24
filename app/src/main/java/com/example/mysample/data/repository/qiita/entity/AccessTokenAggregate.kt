package com.example.mysample.data.repository.qiita.entity

import com.squareup.moshi.Json

data class AccessTokenAggregate(
    @Json(name = "client_id")
    val clientId: String,
    @Json(name = "scopes")
    val scopes: List<String>,
    @Json(name = "token")
    val token: String
)
