//
//  GanhouView.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import SwiftUI

struct GanhouView: View {
    
    @ObservedObject var jvm: JogoViewModel
    var body: some View {
        VStack{
            
        
            Text("Voce Ganhou!")
                .frame(maxWidth: .infinity)
                .frame(maxHeight: .infinity)
                .background(Color.green)
                .ignoresSafeArea()
                .onTapGesture {}
                
            Button("Voltar"){}
                .background(Color.white)
        }}
}

struct GanhouView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(jvm: JogoViewModel())
    }
}
