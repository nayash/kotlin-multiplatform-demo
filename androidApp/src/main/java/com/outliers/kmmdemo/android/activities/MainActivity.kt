package com.outliers.kmmdemo.android.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.outliers.kmmdemo.Greeting
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.outliers.kmmdemo.android.R
import com.outliers.kmmdemo.android.adapter.NoteAdapter
import com.outliers.kmmdemo.shared.KmmSDK
import com.outliers.kmmdemo.shared.cache.DatabaseDriverFactory
import com.outliers.kmmdemo.shared.cache.Note

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    lateinit var kmmSDK: KmmSDK
    lateinit var notes: MutableList<Note>
    lateinit var adapter: NoteAdapter
    lateinit var tvEmpty: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kmmSDK = KmmSDK(DatabaseDriverFactory(this))
        notes = kmmSDK.getAllNotes().toMutableList()

        val rvNotes = findViewById<RecyclerView>(R.id.rv_notes)
        tvEmpty = findViewById(R.id.notes_empy)
        adapter = NoteAdapter(notes)
        rvNotes.adapter = adapter

        if (notes.isEmpty()) {
            tvEmpty.visibility = View.VISIBLE
        } else {
            tvEmpty.visibility = View.GONE
        }

        findViewById<TextView>(R.id.add_note).setOnClickListener {
            launchAddNote()
        }
    }

    private fun launchAddNote() {
        val intent = Intent(this, AddNote::class.java)
        startActivityForResult(intent, 1) // deprecated. use Android recommended method
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // refresh UI with update data
            val note = kmmSDK.getLastNote()
            notes.add(note)
            adapter.itemAdded()
            tvEmpty.visibility = View.GONE
        }
    }
}
