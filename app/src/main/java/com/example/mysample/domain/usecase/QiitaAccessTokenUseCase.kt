package com.example.mysample.domain.usecase

import com.example.mysample.data.mapper.QiitaAccessTokenMapper
import com.example.mysample.data.mapper.util.Mapper
import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.model.QiitaAccessTokenModel.QiitaAccessTokenModel
import com.example.mysample.domain.repository.QiitaRepositoryInterface
import com.example.mysample.domain.usecase.util.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class QiitaAccessTokenUseCase @Inject constructor(
    private val repositoryInterface: QiitaRepositoryInterface
) : BaseUseCase<QiitaAccessTokenUseCase.Parameter, AccessTokenAggregate, QiitaAccessTokenModel>() {

    override fun buildUseCaseSingle(param: Parameter): Single<AccessTokenAggregate> {
        return repositoryInterface.getAccessToken(param.queryParameter)
    }

    override fun getMapper(): Mapper<AccessTokenAggregate, QiitaAccessTokenModel> {
        return QiitaAccessTokenMapper()
    }

    data class Parameter(val queryParameter: AccessTokenQueryParameter)
}