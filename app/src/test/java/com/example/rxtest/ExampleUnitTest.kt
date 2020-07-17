package com.example.rxtest

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {


        val observable: Observable<Int> = Observable.range(1, 5)

        observable.subscribe({
            println("Next $it")
        }, {
            println("Error ${it.message}")
        }, {
            println("Complete")
        })

        observable.subscribeBy(
            onNext = { println("1 $it") },
            onError = { println("Error1 ${it.message}") },
            onComplete = { println("Complete1") }
        )


        val observer: Observer<Int> = object : Observer<Int> {
            override fun onComplete() {
                println("Complete")
            }

            override fun onSubscribe(d: Disposable) {
                println("Subscription")
            }

            override fun onNext(t: Int) {
                println("Next $t")
            }

            override fun onError(e: Throwable) {
                println("Error ${e.message}")
            }
        }

        observable.subscribe(observer)


    }

}