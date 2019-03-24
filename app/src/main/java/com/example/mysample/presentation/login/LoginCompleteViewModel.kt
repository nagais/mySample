package com.example.mysample.presentation.login

import android.annotation.SuppressLint
import com.example.mysample.BuildConfig
import com.example.mysample.data.EncryptSharedPreferences
import com.example.mysample.data.repository.qiita.AccessTokenQueryParameter
import com.example.mysample.domain.usecase.QiitaAccessTokenUseCase
import com.example.mysample.util.crypt.EncodeKeyList
import javax.inject.Inject

class LoginCompleteViewModel @Inject constructor(
    private val useCase: QiitaAccessTokenUseCase,
    private val preferences: EncryptSharedPreferences
) {

    @SuppressLint("CheckResult")
    fun start() {
        val queryParam = AccessTokenQueryParameter(
            clientId = BuildConfig.QIITA_CLIENT_ID,
            clientSecret = BuildConfig.QIITA_CLIENT_SECRET,
            code = preferences.get(EncodeKeyList.KEY_CODE)
        )
        val param = QiitaAccessTokenUseCase.Parameter(queryParam)

        useCase.execute(param)
            .subscribe(
                { response ->
                    preferences.save(EncodeKeyList.KEY_QIITA_TOKEN, response.token)
                },
                { error ->
                    println(error.message)
                })
    }
}