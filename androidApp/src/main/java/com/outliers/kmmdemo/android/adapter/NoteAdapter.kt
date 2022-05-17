package com.outliers.kmmdemo.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.outliers.kmmdemo.android.R
import com.outliers.kmmdemo.shared.cache.Note

class NoteAdapter(val notes: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.title.text = notes[position].title
        holder.body.text = notes[position].body
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_note_title)
        val body: TextView = view.findViewById(R.id.tv_note_body)
    }

    fun itemAdded() {
        notifyItemInserted(notes.size+1)
    }
}