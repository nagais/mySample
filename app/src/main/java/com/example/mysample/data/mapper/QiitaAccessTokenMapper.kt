package com.example.mysample.data.mapper

import com.example.mysample.data.mapper.util.Mapper
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.model.QiitaAccessTokenModel.QiitaAccessTokenModel

class QiitaAccessTokenMapper : Mapper<AccessTokenAggregate, QiitaAccessTokenModel> {

    override fun translate(entity: AccessTokenAggregate): QiitaAccessTokenModel {
        return QiitaAccessTokenModel(
            entity.clientId,
            entity.scopes,
            entity.token
        )
    }
}
