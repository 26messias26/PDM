//
//  ArrochaApp.swift
//  Arrocha
//
//  Created by ifpb on 21/11/22.
//

import SwiftUI

@main
struct ArrochaApp: App {
    var jvm: JogoViewModel = JogoViewModel()
    var body: some Scene {
        WindowGroup {
            ContentView(jvm: JogoViewModel())
        }
    }
}
