//
//  JogoViewModel.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import Foundation

class JogoViewModel: ObservableObject{
    @Published var tela: TelaJogo = .JOGO
    //status
    //menor = 1
    //maior = 100
    //sorteio = Int.random(in: 1 ... 100)
}
