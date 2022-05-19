import SwiftUI
import shared

@main
struct iOSApp: App {
    init(){
        let kmmSdk = KmmSDK(dbDriverFactory: DatabaseDriverFactory())
        kmmSdk.deleteAll()
        for i in 1...5 {
            kmmSdk.insertNote(title: "Note \(i)", body: "body for note \(i) at time=\(NSDate().timeIntervalSince1970)")
        }
    }
    
	var body: some Scene {
		WindowGroup {
            NotesView()
		}
	}
}
