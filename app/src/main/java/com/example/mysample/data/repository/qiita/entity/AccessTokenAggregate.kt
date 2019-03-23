package com.example.mysample.data.repository.qiita.entity

import com.squareup.moshi.Json

data class AccessTokenAggregate(
    @field:Json(name = "client_id")
    val clientId: String,
    @field:Json(name = "scopes")
    val scopes: List<String>,
    @field:Json(name = "token")
    val token: String
)
