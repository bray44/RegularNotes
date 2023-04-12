package com.example.regularnotes

import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintLayoutStates
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.regularnotes.room.Notes
import kotlinx.coroutines.NonDisposableHandle.parent

class NotesRowAdapter(private val listener: OnClickInterface): RecyclerView.Adapter<NotesRowAdapter.NotesRowViewHolder>() {

    private var rows = emptyList<Notes>()


    inner class NotesRowViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var clNoteRow = view.findViewById<ConstraintLayout>(R.id.clNoteRow)
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

        val intent = listener.createIntent()
        intent.putExtra("ROW_ID", rows[position].id)
        intent.putExtra("ROW_TITLE", rows[position].title)
        intent.putExtra("ROW_CONTENT", rows[position].content)

        holder.clNoteRow.setOnClickListener {
            listener.goToActivity(intent)
        }
    }

    fun setData(data: List<Notes>) {
        this.rows = data
        notifyDataSetChanged()
    }
}