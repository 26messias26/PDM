package com.example.ifurna

import android.content.ContentValues
import android.content.Context
import com.example.ifurna.model.Candidato

class DAOPessoa {
    val banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }

    fun insert (candidato: Candidato){
        val cv = ContentValues()
        cv.put("nome",candidato.nome)
        cv.put("numero",candidato.numero)
        this.banco.writableDatabase.insert("candidatos",null,cv)
    }
}