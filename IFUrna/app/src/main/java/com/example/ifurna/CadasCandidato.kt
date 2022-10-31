package com.example.ifurna

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ifurna.model.Candidato
import kotlinx.android.synthetic.main.activity_candidatos.*

class CadasCandidato : AppCompatActivity() {

    private  lateinit var dao: DAOCandidato
    private lateinit var etNome: EditText
    private lateinit var etNumero: EditText
    private lateinit var bCadastrar: Button
    private lateinit var lvCandidatos: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadas_candidato)

        etNome = findViewById(R.id.etNome)
        etNumero = findViewById(R.id.etNumero)
        bCadastrar = findViewById(R.id.bCadastrar)
//        lvCandidatos = findViewById(R.id.lvCandidatos)

//        this.atualizar()
        this.dao = DAOCandidato(this)

        this.bCadastrar.setOnClickListener{salvar()}

    }

    private fun salvar(){
        val nome = this.etNome.text.toString()
        val numero = this.etNumero.text.toString()
        val candidato = Candidato(nome, numero)

        this.etNome.setText("")
        this.etNumero.setText("")
        this.dao.insert(candidato)

        val msg = "${candidato.nome} cadastrado com sucesso!"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        val intent = Intent(this@CadasCandidato,Candidato::class.java).apply {
//            putExtra("PRODUTO", candidato)

        }
            if(intent.resolveActivity(packageManager) != null ){
                startActivity(intent)
                finish()

            }

    }

//    fun atualizar() {
//        val layout = android.R.layout.simple_list_item_1
//        this.lvCandidatos.adapter = ArrayAdapter<Candidato>(this, layout,this.dao.read())
//    }

    inner class OnItemLongClick :AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long): Boolean {

        val candidato = adapter?.getItemAtPosition(index) as Candidato
            this@CadasCandidato.dao.delete(candidato.id)

            val msg = "Candidato ${candidato.nome} inelegível"

            Toast.makeText(this@CadasCandidato , msg, Toast.LENGTH_SHORT).show()

//            this@CadasCandidato.atualizar()

            return true
        }
    }


}