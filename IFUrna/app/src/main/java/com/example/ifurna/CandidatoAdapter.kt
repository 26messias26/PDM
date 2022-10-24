//package com.example.ifurna
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ListView
//import android.widget.TextView
//import androidx.appcompat.view.menu.ActionMenuItemView
//import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView.ViewHolder
//import com.example.ifurna.model.Candidato
//import kotlinx.android.synthetic.main.canditato_item.view.*
//
//class CandidatoAdapter(private val onItemClicked: (Candidato) -> Unit) : RecyclerView.Adapter<ViewHolder>(){
//
//
////    private lateinit var candidatos : List<Candidato> = ArrayList();
//
//    // CandidatoViewHolder
//    class CanditatoVH ( itemView: View): ViewHolder(itemView){
//        private lateinit var tvNomeCand : TextView
//        private lateinit var tvNumCand : TextView
//
//
//            init {
//                tvNomeCand.text = itemView.findViewById(R.id.tvNomeCand)
//                tvNumCand.text =  itemView.findViewById(R.id.tvNumCand)
//            }
//    }
//
//    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
//
//        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.canditato_item,viewGroup,false)
//
//        return view
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        when(holder){
//            is CanditatoVH -> {
//                holder.bind(candidatos[position], onItemClicked)
//            }
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return candidatos.size
//    }
//
//    fun setDataSet(listCandidato: List<Candidato>){
//        this.candidatos = listCandidato
//    }
//
//
//
//}