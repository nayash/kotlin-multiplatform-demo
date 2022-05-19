import SwiftUI
import shared

struct NotesView: View {
	let greet = Greeting().greeting()
    
    let notes = KmmSDK(dbDriverFactory: DatabaseDriverFactory()).getAllNotes()
    var body: some View {
        VStack {
            Text("Notes").font(.title).frame(maxWidth: .infinity, alignment: .center)
            List {
                ForEach(notes, id: \.id) { note in
                    NoteView(note: note)
                }
            }
        }
    }

}

struct NotesView_Previews: PreviewProvider {
	static var previews: some View {
        NotesView()
	}
}
