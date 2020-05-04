package com.demo.rxjava3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.rxjava3.repo.DataRepository
import com.demo.rxjava3.repo.DataValueInterface

class DataViewModel(private val dataRepository: DataRepository) : ViewModel(), DataValueInterface {

    val dataLiveData: MutableLiveData<String> = MutableLiveData()

    fun fetchNewData() {
        dataRepository.fetchData(this)
    }

    override fun onCleared() {
        super.onCleared()
        dataRepository.dispose()
    }

    override fun onRecvData(s: String) {
        dataLiveData.value = s
    }
}