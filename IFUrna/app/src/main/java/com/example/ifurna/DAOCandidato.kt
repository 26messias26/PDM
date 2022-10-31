package com.example.ifurna

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.ifurna.model.Candidato

class DAOCandidato {
    val bancoH: BancoHelper

    constructor(context: Context){
        this.bancoH = BancoHelper(context)
    }

    fun insert (candidato: Candidato){
        val cv = ContentValues()
        cv.put("nome",candidato.nome)
        cv.put("numero",candidato.numero)
        this.bancoH.writableDatabase.insert("candidatos",null,cv)
    }

     fun read() : ArrayList<Candidato>{
         val listCandidatos = arrayListOf<Candidato>()
         val colunas = arrayOf("id", "nome","numero","votos")
         val resultQuery = this.bancoH.readableDatabase.query("candidatos" ,colunas ,null ,null ,null ,null ,"nome")
         resultQuery.moveToFirst()

         for (i in 1 .. resultQuery.count){
             val id = resultQuery.getInt(0)
             val nome = resultQuery.getString(1)
             val numero = resultQuery.getString(2)
             val votos = resultQuery.getInt(3)
             val candidato = Candidato(id, nome, numero, votos)
             listCandidatos.add(candidato)
             resultQuery.moveToNext()
         }

         return listCandidatos
    }

    fun findForNumero(id: Int): Candidato?{
        val colunas = arrayOf("id", "nome","numero")

        val resultQuery = this.bancoH.readableDatabase.query("pessoas", colunas, "numero=?",null , null, null, null)
        resultQuery.moveToFirst()

        val id = resultQuery.getInt(0)
        val nome = resultQuery.getString(1)
        val numero = resultQuery.getString(2)
        val votos = resultQuery.getInt(3)
        val candidato = Candidato(id, nome, numero, votos)

        return candidato
    }

    fun delete(id:Int){
        val id = arrayOf(id.toString())
        this.bancoH.writableDatabase.delete("candidatos","id = ?",id)
    }

    fun update(candidato:Candidato){
        val cv = ContentValues()
        val id = arrayOf(candidato.id.toString())
        cv.put("nome",candidato.nome)
        cv.put("numero",candidato.numero)
        this.bancoH.writableDatabase.update("candidatos",cv,"id = ?",id)
    }

    fun setVoto(candidato:Candidato){
        val id = arrayOf(candidato.id.toString())
        val cv = ContentValues()
        cv.put("votos",candidato.votos)
        this.bancoH.writableDatabase.update("candidatos",cv,"id = ?",id)
    }
}