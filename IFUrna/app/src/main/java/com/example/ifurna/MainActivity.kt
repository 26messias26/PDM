package com.example.ifurna

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btVotar: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btVotar = findViewById(R.id.btVotar)

        this.btVotar.setOnClickListener{
            telaVotar()
        }



    }
    private fun telaVotar(){
        val intent = Intent(this,Votacao::class.java)
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