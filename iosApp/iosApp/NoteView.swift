import SwiftUI
import shared

struct NoteView: View {
    let note: Note
    var body: some View {
        VStack {
            Text(note.title).font(.headline)
            Text(note.body ?? "").font(.subheadline)
        }
    }
}

struct NoteView_Previews: PreviewProvider {
    static var previews: some View {
        NoteView(note: Note(id: 1, title: "Note 1", body: "Body for Note 1"))
    }
}

