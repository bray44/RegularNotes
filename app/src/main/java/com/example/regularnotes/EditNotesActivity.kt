package com.example.regularnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.regularnotes.databinding.ActivityEditRowBinding

class EditNotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditRowBinding
    private lateinit var mViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditRowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.etNoteTitle.setText(intent.getStringExtra("ROW_TITLE"))
        binding.etNoteContent.setText(intent.getStringExtra("ROW_CONTENT"))

        val rowId = intent.getIntExtra("ROW_ID", 4)


        binding.btnDeleteNote.setOnClickListener {
            mViewModel.deleteNotes(rowId)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btnSaveNote.setOnClickListener {
            val rowTitle = binding.etNoteTitle.text.toString()
            val rowContent = binding.etNoteContent.text.toString()
            mViewModel.updateNotes(rowId, rowTitle, rowContent)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}

