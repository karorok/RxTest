package com.example.rxtest

import io.reactivex.rxjava3.kotlin.toObservable
import org.junit.Test

class ConnectableObservableTest {
    @Test
    fun conectableTest() {
        val connectableObservable =
            listOf("String 1", "String 2", "String 3", "String 4").toObservable().publish()
        connectableObservable.subscribe { println("Subscription 1: $it") }
        connectableObservable.map(String::reversed).subscribe {
            println("Subscription 2: $it")
        }
        connectableObservable.connect()
        connectableObservable.subscribe{println("Subscription 3: $it")}     //푸시를 받지 못함.
    }
}