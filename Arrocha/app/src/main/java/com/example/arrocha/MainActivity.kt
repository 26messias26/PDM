package com.example.arrocha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var etNumero: EditText
    private lateinit var btArrocha: Button
    private lateinit var arrocha: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Crinda um novo jogo
        this.arrocha = Arrocha()

        this.etNumero = findViewById(R.id.etMainNumero)
        this.btArrocha = findViewById(R.id.btMainArrocha)

        this.btArrocha.setOnClickListener(OnClinkBotao())

    }

    inner class OnClinkBotao: View.OnClickListener{
        override fun onClick(p0: View?) {

            var numero = this@MainActivity.etNumero.text.toString()
            if (numero != "") {

                var dica = this@MainActivity.arrocha.jogar(numero.toInt()).toString()

                if (this@MainActivity.arrocha.getStatus() == Status.EXECUTANDO){
                    Toast.makeText(this@MainActivity,dica, Toast.LENGTH_SHORT).show()
                }else{
                    //troca de tela
                    val intent = Intent(this@MainActivity, resultado::class.java).apply{
                        putExtra("JOGO", this@MainActivity.arrocha)
                    }
                    startActivity(intent)

                    // Inicia um novo jogo

                    this@MainActivity.arrocha = Arrocha()
                }

            }else{
                Toast.makeText(this@MainActivity,"Insira um numero por favor!",Toast.LENGTH_SHORT).show()
            }

            //limpa o campo de texto
            this@MainActivity.etNumero.setText("")
        }
    }

}