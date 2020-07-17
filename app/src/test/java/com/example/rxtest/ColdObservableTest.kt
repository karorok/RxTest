package com.example.rxtest

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.toObservable
import org.junit.Test

class ColdObservableTest {
    @Test
    fun coldTest() {
        val observable: Observable<String> =
            listOf("String 1", "String 2", "String 3", "String 4").toObservable()
        observable.subscribe(
            {
                println("Receive $it")
            }, {
                println("Error ${it.message}")
            }, {
                println("Done")
            }
        )
        observable.subscribe(
            {
                println("Receive $it")
            }, {
                println("Error ${it.message}")
            }, {
                println("Done")
            }
        )
    }
}