package com.example.regularnotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.regularnotes.room.Notes

class NotesRowAdapter: RecyclerView.Adapter<NotesRowAdapter.NotesRowViewHolder>() {

    private var rows = emptyList<Notes>()

    inner class NotesRowViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvNoteTitle = view.findViewById<TextView>(R.id.tvNoteTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesRowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_row, parent, false)
        return NotesRowViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rows.size
    }

    override fun onBindViewHolder(holder: NotesRowViewHolder, position: Int) {
        holder.tvNoteTitle.text = rows[position].title
    }

    fun setData(data: List<Notes>) {
        this.rows = data
        notifyDataSetChanged()
    }

}