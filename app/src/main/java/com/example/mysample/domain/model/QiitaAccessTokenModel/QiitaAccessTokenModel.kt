package com.example.mysample.domain.model.QiitaAccessTokenModel

data class QiitaAccessTokenModel(
    val clientId: String,
    val scopes: List<String>,
    val token: String
)
