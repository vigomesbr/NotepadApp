package com.example.logonrmlocal.notepadapp.api

import com.example.logonrmlocal.notepadapp.model.Nota
import retrofit2.Call
import retrofit2.http.*

interface NotaAPI {

    @GET("/note")
    fun buscarTodos(): Call<List<Nota>>

    @GET("/note/titulo/{titulo}")
    fun buscaPorTitulo(@Path("titulo") titulo: String): Call<List<Nota>>

    @POST("/note")
    fun salvar(@Body nota: Nota): Call<Nota>

    @DELETE("/note/{id}")
    fun deletar(@Path("id")id: String): Call<Nota>

}