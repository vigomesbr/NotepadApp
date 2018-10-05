package com.example.logonrmlocal.notepadapp.view.formulario

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.logonrmlocal.notepadapp.R
import com.example.logonrmlocal.notepadapp.model.ResponseStatus
import kotlinx.android.synthetic.main.activity_formulario.*

class FormularioActivity : AppCompatActivity() {

    lateinit var formularioViewModel: FormularioViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        formularioViewModel = ViewModelProviders.of(this).get(FormularioViewModel::class.java)


formularioViewModel.responseStatus.observe(this, responseStatusObserver)
        btSalvar.setOnClickListener {
            formularioViewModel.salvar(
                    etTitulo.text.toString(),
                    etDescricao.text.toString()
            )
        }
    }

    private  var responseStatusObserver = Observer<ResponseStatus>{
        if (it?.sucesso == true){
            setResult(Activity.RESULT_OK)
            finish()
        } else {
            Toast.makeText(this,
                    it?.mensagem,
                    Toast.LENGTH_SHORT).show()
        }
    }
}
