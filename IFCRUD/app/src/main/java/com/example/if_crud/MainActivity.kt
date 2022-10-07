package com.example.if_crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var button:Button
    private  lateinit var editText: EditText
    private  lateinit var listView: AbsListView

    private lateinit var dao: PessoaDAO


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.dao = PessoaDAO(this)

        this.button = findViewById(R.id.btSalvar)
        this.editText = findViewById(R.id.etNome)
        this.listView = findViewById(R.id.listView)

        this.listView.setOnItemClickListener(OnIntemClick())
        this.listView.setOnItemClickListener(OnIntemClick())

        this.button.setOnClickListener(){salvar()}
    }

    fun salvar(){
        val nome = this.editText.text.toString()
        val pessoa = Pessoa(nome)

        this.dao.insert(pessoa)
        this.atualizar()
        this.editText.setText("")
    }

    fun atualizar(){
        val adapter = ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_1,this.dao.read())

        this.listView.adapter = adapter
    }

    inner class OnIntemClick: AdapterView.OnItemClickListener{
        override fun onItemClick(adapter: AdapterView<*>?, p1: View?, index: Int, p3: Long) {
            val pessoa = adapter?.getItemAtPosition(index) as Pessoa
            Toast.makeText(this@MainActivity, pessoa?.nome, Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnItemLongClick: AdapterView.OnItemClickListener{
        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long) {

        }
    }
}