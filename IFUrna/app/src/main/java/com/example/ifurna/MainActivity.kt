package com.example.ifurna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btVotar: Button;
    private lateinit var btCandidatos: Button;
    private lateinit var btResultado: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btVotar = findViewById(R.id.btVotar)
        this.btCandidatos = findViewById(R.id.btCandidatos)
        this.btResultado = findViewById(R.id.btResultado)


        this.btVotar.setOnClickListener{
            telaVotar()
        }
        this.btCandidatos.setOnClickListener{
            telaCandidatos()
        }
        this.btResultado.setOnClickListener{
            telaResultado()
        }



    }
    private fun telaVotar(){
        val intent = Intent(this,Votacao::class.java)
        startActivity(intent)
    }

    private fun telaCandidatos(){
        val intent = Intent(this,Candidatos::class.java)
        startActivity(intent)
    }

    private fun telaResultado(){
        val intent = Intent(this,Resultado::class.java)
        startActivity(intent)
    }

//    inner class OnClick: View.OnClickListener{
//        override  fun onClick(v:View?){
//            val intent = Intent(this@MainActivity, Votacao::class.java)
//
//            if(intent.resolveActivity(packageManager) != null){
//                startActivity(intent)
//            }
//        }
//    }
}