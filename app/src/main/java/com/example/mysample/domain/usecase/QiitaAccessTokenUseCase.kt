package com.example.mysample.domain.usecase

import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.repository.QiitaAccessTokenRepositoryInterface
import com.example.mysample.domain.usecase.util.BaseUseCase
import io.reactivex.Single
import javax.inject.Inject

class QiitaAccessTokenUseCase @Inject constructor(private val repository: QiitaAccessTokenRepositoryInterface) :
    BaseUseCase<QiitaAccessTokenUseCase.Parameter, AccessTokenAggregate>() {

    override fun buildUseCaseSingle(param: Parameter): Single<AccessTokenAggregate> {
        return repository.getAccessToken(param.queryParameter)
    }

    data class Parameter(val queryParameter: AccessTokenQueryParameter)
}