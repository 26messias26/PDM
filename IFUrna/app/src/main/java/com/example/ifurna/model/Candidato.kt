package com.example.ifurna.model

class Candidato {
    var id: Int
    var nome: String
    var numero: String
    var votos: Int

    //Cadastrando candidato
    constructor(nome:String, numero:String){
        this.id = -1
        this.nome = nome
        this.numero = numero
        this.votos = 0
    }

    // Carregando do banco
    constructor(id:Int, nome:String, numero: String, votos: Int){
        this.id = id
        this.nome = nome
        this.numero = numero
        this.votos = votos
    }

    }




