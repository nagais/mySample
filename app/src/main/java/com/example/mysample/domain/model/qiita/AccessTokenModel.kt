package com.example.mysample.domain.model.qiita

data class AccessTokenModel(
    val clientId: String,
    val scopes: List<String>,
    val token: String
)
