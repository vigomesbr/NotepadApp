package com.example.logonrmlocal.notepadapp.view.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notepadapp.model.Nota
import com.example.logonrmlocal.notepadapp.repository.NotaRepository

class MainViewModel : ViewModel() {

    val notaRepository = NotaRepository()
    var notas: MutableLiveData<List<Nota>> = MutableLiveData()
    var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos(){
        isLoading.value = true
        notaRepository.buscarTodos(onComplete = {
            isLoading.value = false
            notas.value = it
        }, onError = {
            isLoading.value = false
            notas.value = mutableListOf()
        })
    }

}