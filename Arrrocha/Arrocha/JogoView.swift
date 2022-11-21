//
//  jogo.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import SwiftUI

struct JogoView: View {
    @State var chute: String = ""
    @ObservedObject var jvm: JogoViewModel
    var body: some View {
        VStack{
            Spacer()
            HStack{
                Spacer()
                Text("")
                Spacer()
                Text("e")
                Spacer()
                Text("")
                Spacer()
            }.font(.largeTitle)
            Spacer()
            TextField("Chute",text: self.$chute)
                .frame(width: 100)
                .background(Color.blue.opacity(0.4))
                .foregroundColor(Color.white)
            
            Button("Arrochar"){}
            Spacer()
        }
            .padding()
    }
}

struct jogo_Previews: PreviewProvider {
    static var previews: some View {
        ContentView(jvm: JogoViewModel())
    }
}
