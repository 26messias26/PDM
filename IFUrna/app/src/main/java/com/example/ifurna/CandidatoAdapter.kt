package com.example.ifurna

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.ifurna.model.Candidato
import kotlinx.android.synthetic.main.canditato_item.view.*

class CandidatoAdapter(private val onItemClicked: (Candidato) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var candidatos : List<Candidato> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return CanditatoVH(LayoutInflater.from(parent.context).inflate(R.layout.canditato_item,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder){
            is CanditatoVH -> {
                holder.bind(candidatos[position], onItemClicked)
            }
        }

    }

    override fun getItemCount(): Int {
        return candidatos.size
    }

    fun setDataSet(listCandidato: List<Candidato>){
        this.candidatos = listCandidato
    }

    // CandidatoViewHolder
    class CanditatoVH constructor( itemView: View): RecyclerView.ViewHolder(itemView){
        private val tvNomeCand = itemView.tvNomeCand
        private val tvNumCand = itemView.tvNumCand

        fun bind(candidato: Candidato, onItemClicked: (Candidato) -> Unit){

            tvNomeCand.text = candidato.nome
            tvNumCand.text = candidato.numero

            itemView.setOnClickListener{
                onItemClicked(candidato)
            }
        }
    }

}