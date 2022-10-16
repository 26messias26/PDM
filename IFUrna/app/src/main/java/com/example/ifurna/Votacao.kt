package com.example.ifurna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextSwitcher

class Votacao : AppCompatActivity() {

    private lateinit var etINum : EditText
    private lateinit var etIINum : EditText
    private lateinit var etIIINum : EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_votacao)

        this.etINum = findViewById(R.id.etINum)
        this.etIINum = findViewById(R.id.etIINum)
        this.etIIINum = findViewById(R.id.etIIINum)

        //TROCA O FOCO AO DIGITAR O NUMERO
        etINum.addTextChangedListener( object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (!TextUtils.isEmpty(etINum.getText())){
                    etIINum.requestFocus()
                }
            }
        });

        etIINum.addTextChangedListener( object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (TextUtils.isEmpty(etIINum.getText())){
                    etINum.requestFocus()
                }else{
                    etIIINum.requestFocus()
                }
            }
        });

        etIIINum.addTextChangedListener( object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                if (TextUtils.isEmpty(etIIINum.getText())){
                    etIINum.requestFocus()

                }
            }
        });


    }
}
