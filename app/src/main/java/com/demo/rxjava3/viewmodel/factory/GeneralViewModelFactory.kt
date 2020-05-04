package com.demo.rxjava3.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.rxjava3.repo.DataRepository
import com.demo.rxjava3.viewmodel.DataViewModel

class GeneralViewModelFactory:ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(DataViewModel::class.java)){
                return DataViewModel(DataRepository()) as T
            }else{
                throw IllegalArgumentException()
            }
    }
}