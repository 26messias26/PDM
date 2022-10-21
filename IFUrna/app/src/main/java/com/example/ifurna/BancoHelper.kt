package com.example.ifurna

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.ifurna.model.Candidato
import java.lang.Integer.parseInt

class BancoHelper (context:Context): SQLiteOpenHelper(context,"db_urna", null, 1){

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "create table candidatos("+
                "id integer primary key autoincrement, " +
                "nome text," +
                "numero text,"+
                "votos integer)"

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table candidatos")
        this.onCreate(db)
    }

    fun selectAll(): ArrayList<Candidato>{
        val lista = ArrayList<Candidato>()
        val db = writableDatabase
        val query = "SELECT * FROM candidatos"
        val cursor = db.rawQuery(query,null)
        if(cursor != null){
            if(cursor.moveToFirst()){
                for (i in 1..cursor.count){
                    val id = cursor.getInt(0)
                    val nome = cursor.getString(1)
                    val numero = cursor.getString(2)
                    val votos = cursor.getInt(3)
                    lista.add(Candidato(id, nome, numero,votos))
                    cursor.moveToNext()
                }
            }
        }
        return lista
    }

    fun insert(candidato: Candidato){

        val db = writableDatabase
        val cv = ContentValues()
        cv.put("nome",candidato.nome)
        cv.put("numero",candidato.numero)
        db.insert("candidatos",null,cv)
        db.close()

    }

    fun delete(id: Int): Boolean{
        val db = writableDatabase
        val success = db.delete("candidato","id=?",arrayOf(id.toString()))

        return parseInt(success.toString()) != -1

    }


}