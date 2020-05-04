package com.demo.rxjava3.repo

import io.reactivex.rxjava3.subjects.BehaviorSubject

class DataRepository {
    private val behaviorSubject: BehaviorSubject<String> = BehaviorSubject.create<String>();
    private var num = 53

    public fun fetchData(i: DataValueInterface) {
        val disposable = behaviorSubject.subscribe { i.onRecvData(it) }
        behaviorSubject.onNext(num++.toChar().toString())
        disposable.dispose()
    }

    public fun dispose(){
        behaviorSubject.onComplete()
    }
}

interface DataValueInterface {
    public fun onRecvData(s: String)
}