//
//  ContentView.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import SwiftUI

struct ContentView: View {
    @ObservedObject var jvm: JogoViewModel
    
    var body: some View {
        if(self.jvm.tela == .JOGO){
            JogoView(jvm: JogoViewModel())
        }else if(self.jvm.tela == .GANHOU){
            GanhouView(jvm: JogoViewModel())
        }else{
            PerdeuView(jvm: JogoViewModel())
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(jvm: JogoViewModel())
    }
}
