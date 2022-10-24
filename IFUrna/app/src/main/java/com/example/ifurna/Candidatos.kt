package com.example.ifurna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ifurna.model.Candidato
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_candidatos.*

class Candidatos : AppCompatActivity() {

    private lateinit var faButton: FloatingActionButton
    private lateinit var lvCandidatos: ListView
    private lateinit var dao : DAOCandidato
//    lateinit var candidatoAdapter: CandidatoAdapter
//    lateinit var dbBancoHelper: BancoHelper



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidatos)

        this.dao = DAOCandidato(this)
        this.faButton = findViewById(R.id.faButton)
        this.lvCandidatos = findViewById(R.id.lvCandidatos)

//        this.lvCandidatos.setOnItemClickListener(OnItemClick())
        this.lvCandidatos.setOnLongClickListener(OnItemLongClick())

        this.faButton.setOnClickListener{ addCandidatos() }
    }

    fun addCandidatos(){
        val intent = Intent(this,CadasCandidato::class.java)
            startActivity(intent)
    }


//    inner class addOnClick: AdapterView.OnItemClickListener{
//        override fun onItemClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long) {
//            val intent = Intent(this@Candidatos,CadasCandidato::class.java)
//            startActivity(intent)
//        }
//    }

//    inner class OnItemClick: AdapterView.OnItemClickListener{
//        override fun onItemClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long) {
//            val pessoa = adapter?.getItemAtPosition(index) as Candidato
//            Toast.makeText(this@Candidatos, pessoa?.nome, Toast.LENGTH_SHORT).show()
//        }
//    }

    fun carregarLV(){
        val layout = android.R.layout.simple_list_item_1
        this.lvCandidatos.adapter = ArrayAdapter<Candidato>(this, layout,this.dao.read())
    }

    private fun excluir(nome: String) {
        println("apagou!! "+nome)
    }

    fun atualizar() {
        val layout = android.R.layout.simple_list_item_1
        this.lvCandidatos.adapter = ArrayAdapter<Candidato>(this, layout,this.dao.read())
    }

    inner class OnItemLongClick :AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(adapter: AdapterView<*>?, view: View?, index: Int, id: Long): Boolean {

            val candidato = adapter?.getItemAtPosition(index) as Candidato
            this@Candidatos.dao.delete(candidato.id)

            val msg = "Candidato ${candidato.nome} inelegível"

            Toast.makeText(this@Candidatos , msg, Toast.LENGTH_SHORT).show()

            this@Candidatos.atualizar()

            return true
        }
    }
}

private fun ListView.setOnLongClickListener(onItemLongClick: Candidatos.OnItemLongClick) {

}
