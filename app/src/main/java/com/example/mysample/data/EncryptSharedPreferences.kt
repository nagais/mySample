package com.example.mysample.data

import android.content.SharedPreferences
import com.example.mysample.BuildConfig
import com.example.mysample.util.crypt.CryptUtil
import javax.inject.Inject


class EncryptSharedPreferences constructor(private val sharedPreferences: SharedPreferences) {

    fun save(key: String, data: String) {
        val encKey = CryptUtil.encrypt(key, BuildConfig.SECRET_KEY)
        val encData = CryptUtil.encrypt(data, BuildConfig.SECRET_KEY)

        sharedPreferences.edit()
            .putString(encKey, encData)
            .apply()
    }

    fun get(key: String): String? {
        val encKey = CryptUtil.encrypt(key, BuildConfig.SECRET_KEY)
        val loadData = sharedPreferences.getString(encKey, null)
        loadData?.apply {
            return CryptUtil.decrypt(loadData, BuildConfig.SECRET_KEY)
        }
        return null
    }

    fun delete(key: String) {
        val encKey = CryptUtil.encrypt(key, BuildConfig.SECRET_KEY)
        sharedPreferences.edit()
            .remove(encKey)
            .apply()
    }

    fun clear() {
        sharedPreferences.edit()
            .clear()
            .apply()
    }
}