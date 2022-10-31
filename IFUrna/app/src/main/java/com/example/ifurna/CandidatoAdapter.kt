package com.example.ifurna

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ifurna.model.Candidato
import kotlinx.android.synthetic.main.canditato_item.view.*

class CandidatoAdapter(private val contexto:Activity, private val arrayList: ArrayList<Candidato>): ArrayAdapter<Candidato>(contexto,R.layout.canditato_item,arrayList){


//    private lateinit var candidatos : List<Candidato> = ArrayList();

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.canditato_item,null);

        val tvNomeCand : TextView = view.findViewById(R.id.tvNomeCand)
        val tvNumCand : TextView =  view.findViewById(R.id.tvNumCand)

        tvNomeCand.text = arrayList[position].nome
        tvNumCand.text = arrayList[position].numero

        return view
    }






}