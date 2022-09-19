package com.example.arrocha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class resultado : AppCompatActivity() {

    private lateinit var tvResultado: TextView
    private lateinit var llResultado: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)


        this.tvResultado = findViewById(R.id.tvResultado)
        this.llResultado = findViewById(R.id.llResultado)

        this.llResultado.setOnClickListener(OnClickRestart())

        if (intent.hasExtra("JOGO")){
            val jogo = intent.getSerializableExtra("JOGO") as Arrocha

            this.llResultado.background
            this.tvResultado.setText(jogo.getStatus().toString())
        }
    }

    inner class OnClickRestart : View.OnClickListener{
        override fun onClick(p0: View?) {
            val intent = Intent(this@resultado, MainActivity::class.java)
            startActivity(intent)
        }
    }
}