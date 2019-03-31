package com.example.mysample.data.mapper

import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.model.qiita.AccessTokenModel

object AccessTokenMapper {

    fun translate(entity: AccessTokenAggregate): AccessTokenModel {
        return AccessTokenModel(
            entity.clientId,
            entity.scopes,
            entity.token
        )
    }
}