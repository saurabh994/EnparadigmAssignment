package com.example.enparadigmassignment.common.extension

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


fun Disposable.disposeWith(compositeDisposable: CompositeDisposable?) =
    compositeDisposable?.add(this)

inline fun <reified T> Single<T>.request(
    noinline onSubscribe: () -> Unit,
    noinline onTerminate: () -> Unit,
    crossinline onSuccess: (T) -> Unit,
    noinline onError: (Throwable) -> Unit
): Disposable {
    return applyIoScheduler()
        .doOnSubscribe { onSubscribe() }
//        .doOnTerminate { onTerminate() }
        .subscribe({ next ->
           onSuccess(next)
        }, { error ->
            onError(error)
        })
}

//Single
fun <T> Single<T>.applyIoScheduler() = applyScheduler(Schedulers.io())

private fun <T> Single<T>.applyScheduler(scheduler: Scheduler) =
    subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread())