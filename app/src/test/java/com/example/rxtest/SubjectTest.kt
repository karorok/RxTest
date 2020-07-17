package com.example.rxtest

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.AsyncSubject
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.ReplaySubject
import org.junit.Test
import java.util.concurrent.TimeUnit.MILLISECONDS

class SubjectTest {

    @Test
    fun subjectTest() {
        val observable = Observable.interval(100, MILLISECONDS)
        val subject = PublishSubject.create<Long>()
        observable.subscribe(subject)
        subject.subscribe {
            println("Received $it")
        }
    }

    @Test
    fun asyncSubjectTest() {
        val observable = Observable.just(1, 2, 3, 4)
        val subject = AsyncSubject.create<Int>()
        observable.subscribe(subject)
        subject.subscribe({
            println("Received $it")
        }, {
            it.printStackTrace()
        }, {
            println("Complete")
        }
        )
        subject.onComplete()
    }

    @Test
    fun subjectTest2() {
        val subject = AsyncSubject.create<Int>()
        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(3)
        subject.onNext(4)
        subject.subscribe(
            {
                println("S1 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S1 Complete")
            }
        )
        subject.onNext(5)
        subject.subscribe(
            {
                println("S2 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S2 Complete")
            }
        )
        subject.onComplete()
    }

    @Test
    fun behaviorSubject() {
        val subject = BehaviorSubject.create<Int>()
        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(3)
        subject.onNext(4)
        subject.subscribe(
            {
                println("S1 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S1 Complete")
            }
        )
        subject.onNext(5)
        subject.subscribe(
            {
                println("S2 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S2 Complete")
            }
        )
        subject.onComplete()
    }

    @Test
    fun replaySubjectTest() {
        val subject = ReplaySubject.create<Int>()
        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(3)
        subject.onNext(4)
        subject.subscribe(
            {
                println("S1 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S1 Complete")
            }
        )
        subject.onNext(5)
        subject.subscribe(
            {
                println("S2 Received $it")
            }, {
                it.printStackTrace()
            }, {
                println("S2 Complete")
            }
        )
        subject.onComplete()
    }
}