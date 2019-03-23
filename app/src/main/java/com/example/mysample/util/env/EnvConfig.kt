package com.example.mysample.util.env

import com.example.mysample.BuildConfig

object EnvConfig {

    const val QIITA_OAUTH_URL =
        "https://qiita.com/api/v2/oauth/authorize?client_id=${BuildConfig.QIITA_CLIENT_ID}&scope=read_qiita"
}