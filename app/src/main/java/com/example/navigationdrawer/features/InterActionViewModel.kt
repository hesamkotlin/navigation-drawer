package com.example.navigationdrawer.features

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InterActionViewModel :ViewModel() {

    private val _onViewTypeChanged = MutableLiveData<Boolean>(true)
    val onViewTypeChanged :LiveData<Boolean> = _onViewTypeChanged


    fun emitOnViewTypeChanged(isLinear : Boolean){
        _onViewTypeChanged.value = isLinear
    }
}