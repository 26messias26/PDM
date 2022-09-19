package com.example.arrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        if (intent.hasExtra("JOGO")){
            val jogo = intent.getSerializableExtra("JOGO") as Arrocha

            this.llResultado.background
            this.tvResultado.setText(jogo.getStatus().toString())
        }
    }
}