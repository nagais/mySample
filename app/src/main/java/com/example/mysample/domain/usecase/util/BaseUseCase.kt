package com.example.mysample.domain.usecase.util

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase<in PARAM, RESPONSE> {

    private val compositeDisposable = CompositeDisposable()

    internal abstract fun buildUseCaseSingle(param: PARAM): Single<RESPONSE>

    fun execute(observable: DisposableSingleObserver<RESPONSE>, param: PARAM): Single<RESPONSE> {
        val single = buildUseCaseSingle(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

        compositeDisposable.add(single.subscribeWith(observable))

        return single
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}