package com.example.mysample.domain.usecase.util

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase<in PARAM, RESPONSE> {

    private val compositeDisposable = CompositeDisposable()

    internal abstract fun buildUseCaseSingle(param: PARAM): Single<RESPONSE>

    fun execute(param: PARAM): Single<RESPONSE> {
        return buildUseCaseSingle(param)
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .doOnSubscribe { dispose -> compositeDisposable.add(dispose) }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}