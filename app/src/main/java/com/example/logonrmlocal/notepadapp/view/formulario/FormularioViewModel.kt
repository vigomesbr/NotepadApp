package com.example.logonrmlocal.notepadapp.view.formulario

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrmlocal.notepadapp.model.Nota
import com.example.logonrmlocal.notepadapp.model.ResponseStatus
import com.example.logonrmlocal.notepadapp.repository.NotaRepository

class FormularioViewModel: ViewModel(){

    val notaRepository = NotaRepository()

    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()
    fun salvar(titulo: String, descricao: String) {

        val nota = Nota(null,titulo, descricao)
        notaRepository.salvar(nota,
                onComplete = {
                    responseStatus.value = ResponseStatus(true, "deu certo")
                }, onError = {
            responseStatus.value = ResponseStatus(false, it?.message!!)
        })
    }
}