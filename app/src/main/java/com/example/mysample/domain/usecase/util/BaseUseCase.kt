package com.example.mysample.domain.usecase.util

import com.example.mysample.data.mapper.util.Mapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


abstract class BaseUseCase<in PARAM, RESPONSE, DATA_OBJECT> {

    private val compositeDisposable = CompositeDisposable()

    internal open var doOnSuccess: ((RESPONSE) -> Unit)? = null

    internal open var doOnError: ((Throwable) -> Unit)? = null

    var completeListener: ((data: DATA_OBJECT) -> Unit)? = null

    protected abstract fun buildUseCaseSingle(param: PARAM): Single<RESPONSE>

    fun execute(param: PARAM): BaseUseCase<PARAM, RESPONSE, DATA_OBJECT> {
        val dispose = buildUseCaseSingle(param)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { response: RESPONSE ->
                val data = translate(response)
                complete(data)
                doOnSuccess?.invoke(response)
            }
            .doOnError { err ->
                doOnError?.invoke(err)
            }
            .subscribe()
        compositeDisposable.add(dispose)
        return this
    }

    protected abstract fun getMapper(): Mapper<RESPONSE, DATA_OBJECT>

    private fun translate(response: RESPONSE): DATA_OBJECT {
        return getMapper().translate(response)
    }

    protected open fun complete(dataObject: DATA_OBJECT) {
        completeListener?.invoke(dataObject)
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}