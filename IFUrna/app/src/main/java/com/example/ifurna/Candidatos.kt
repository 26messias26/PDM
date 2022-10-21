package com.example.ifurna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ifurna.model.Candidato
import kotlinx.android.synthetic.main.activity_candidatos.*

class Candidatos : AppCompatActivity() {

    private lateinit var faButton: Button
    private lateinit var rvCandidatos: RecyclerView
    lateinit var candidatoAdapter: CandidatoAdapter
    lateinit var dbBancoHelper: BancoHelper
    private var candidatos: List<Candidato> = ArrayList<Candidato>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_candidatos)

        faButton = findViewById(R.id.floatingActionButton)

        candidatos = dbBancoHelper!!.selectAll()
        dbBancoHelper = BancoHelper(this)
        initRecyclerView()
        addDataSource()

        faButton.setOnClickListener{
            val intent = Intent(this,CadasCandidato::class.java)
            startActivity(intent)
        }

    }

    private fun addDataSource() {

    }

    private fun initRecyclerView() {
        this.candidatoAdapter = CandidatoAdapter({
            candidato ->  excluir(candidato.nome)
        })

        rvCandidatos.layoutManager = LinearLayoutManager(this@Candidatos)

        rvCandidatos.adapter = this.candidatoAdapter

        this.candidatoAdapter.notifyDataSetChanged()
    }

    private fun excluir(nome: String) {
        println("apagou!! "+nome)
    }
}