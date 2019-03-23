package com.example.mysample.presentation.login

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

    fun start() {
        val param = AccessTokenQueryParameter(
            clientId = BuildConfig.QIITA_CLIENT_ID,
            clientSecret = BuildConfig.QIITA_CLIENT_SECRET,
            code = preferences.get(EncodeKeyList.KEY_CODE)
        )
    }
}