package com.example.mysample.presentation.login

import com.example.mysample.BuildConfig
import com.example.mysample.data.storage.EncryptSharedPreferences
import com.example.mysample.data.mapper.AccessTokenMapper
import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.data.repository.qiita.entity.AccessTokenAggregate
import com.example.mysample.domain.usecase.QiitaAccessTokenUseCase
import com.example.mysample.util.crypt.EncodeKeyList
import com.example.mysample.util.helper.Navigator
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class LoginCompleteViewModel @Inject constructor(
    private val useCase: QiitaAccessTokenUseCase,
    private val preferences: EncryptSharedPreferences
) {

    fun start() {
        val queryParam = AccessTokenQueryParameter(
            clientId = BuildConfig.QIITA_CLIENT_ID,
            clientSecret = BuildConfig.QIITA_CLIENT_SECRET,
            code = preferences.get(EncodeKeyList.KEY_CODE)
        )
        val param = QiitaAccessTokenUseCase.Parameter(queryParam)

        useCase.execute(object : DisposableSingleObserver<AccessTokenAggregate>() {
            override fun onSuccess(entity: AccessTokenAggregate) {
                val model = AccessTokenMapper.translate(entity)
                preferences.save(EncodeKeyList.KEY_QIITA_TOKEN, model.token)
                Navigator.navigateTopActivity()
            }

            override fun onError(e: Throwable) {
                println(e.message)
            }
        }, param)
    }
}