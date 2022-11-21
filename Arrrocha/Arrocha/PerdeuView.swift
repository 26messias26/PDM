//
//  PerdeuView.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import SwiftUI

struct PerdeuView: View {
    @ObservedObject var jvm: JogoViewModel
    var body: some View {
        VStack{
        
            Text("Voce Perdeu!")
                .frame(maxWidth: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/)
                .frame(maxHeight: /*@START_MENU_TOKEN@*/.infinity/*@END_MENU_TOKEN@*/)
                .background(Color.red)
                .ignoresSafeArea()
                .onTapGesture {}
            Button("Voltar"){}
                .background(Color.white)
        
        }
    }
}

struct PerdeuView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(jvm: JogoViewModel())
    }
}
