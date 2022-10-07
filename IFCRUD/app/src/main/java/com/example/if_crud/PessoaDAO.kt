package com.example.if_crud

import android.content.ContentValues
import android.content.Context

class PessoaDAO {
    val banco: BancoHelper

    constructor(context: Context){
        this.banco = BancoHelper(context)
    }


    fun insert(pessoa: Pessoa){
        val cv = ContentValues()
        cv.put("nome",pessoa.nome)
        cv.put("data",pessoa.data.timeInMillis)
        this.banco.writableDatabase.insert("pessoas",null,cv)
    }

    fun read():ArrayList<Pessoa>{
        val lista = arrayListOf<Pessoa>()
        val colunas = arrayOf("id","nome","data")
        val cursor = this.banco.readableDatabase.query("pessoas",colunas,null,null,null,null,"nome")

        cursor.moveToFirst()

        for (i in 1 .. cursor.count){
            val id = cursor.getInt(0)
            val nome = cursor.getString(1)
            val data = cursor.getLong(2)
            val pessoa = Pessoa(id,nome,data)

            lista.add(pessoa)
        }


        return lista
    }

    fun read(id:Int):Pessoa?{
        return null
    }

    fun delete(id: Int){
        val where = arrayOf(id.toString())
        this.banco.writableDatabase.delete("pessoas","id = ?",where)
    }

    fun delete(pessoa:Pessoa){
        this.delete(pessoa.id)
    }

    fun update(pessoa: Pessoa){}
}