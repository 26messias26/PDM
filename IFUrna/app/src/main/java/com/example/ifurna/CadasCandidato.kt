package com.example.ifurna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.ifurna.model.Candidato

class CadasCandidato : AppCompatActivity() {

    private  lateinit var dao: DAOCandidato
    private lateinit var etNome: EditText
    private lateinit var etNumero: EditText
    private lateinit var bCadastrar: Button
    private lateinit var lvCandidatos: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadas_candidato)

        etNome = findViewById(R.id.etNome)
        etNumero = findViewById(R.id.etNumero)
        bCadastrar = findViewById(R.id.bCadastrar)
        this.lvCandidatos = findViewById(R.id.lvCandidatos)

        this.dao = DAOCandidato(this)

//        this.lvCandidatos.setOnLongClickListener(OnItemLongClick())

        this.bCadastrar.setOnClickListener{salvar()}

    }

    fun salvar(){
        val nome = this.etNome.text.toString()
        val numero = this.etNumero.text.toString()
        val candidato = Candidato(nome, numero)

        this.atualizar()
        this.etNome.setText("")
        this.etNumero.setText("")
    }

    fun atualizar() {
        val layout = android.R.layout.simple_list_item_1
        this.lvCandidatos.adapter = ArrayAdapter<Candidato>(this, layout,this.dao.read())
    }

    inner class OnItemLongClick :AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long): Boolean {

        val candidato = adapter?.getItemAtPosition(index) as Candidato
            this@CadasCandidato.dao.delete(candidato.id)

            val msg = "Candidato ${candidato.nome} inelegível"

            Toast.makeText(this@CadasCandidato , msg, Toast.LENGTH_SHORT).show()

            this@CadasCandidato.atualizar()

            return true
        }
    }


}